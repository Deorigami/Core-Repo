package com.byu.id.core.extension

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.byu.id.core.base.BaseUseCase
import com.byu.id.core.model.Error
import kotlinx.coroutines.CoroutineScope

class StatefulLiveData<P, R>(
    private val executor : BaseUseCase<P,R>,
    private val coroutineScope : CoroutineScope,
    private val isNeedTrigger: Boolean = false
) {

    val onSuccess = MediatorLiveData<R>()
    val onError = MediatorLiveData<Error>()
    val onCanceled = MediatorLiveData<Unit>()
    val isLoading = MediatorLiveData<Boolean>()
    val isTriggered = MediatorLiveData<Boolean>()
    val executable = MediatorLiveData<P>()
    val statefulResultLiveData: MediatorLiveData<StatefulResult<R>> = MediatorLiveData()

    fun cancel() {
        executor.cancel()
        onCanceled.postValue(Unit)
        isTriggered.postValue(false)
        isLoading.postValue(false)
    }

    fun listen(
        owner : LifecycleOwner,
        onSuccess : ((R) -> Unit)? = null,
        onError : ((Error) -> Unit)? = null,
        onStart : (() -> Unit)? = null,
        onComplete : (() -> Unit)? = null,
        onCanceled : (() -> Unit)? = null,
    ){
        this.onSuccess.observe(owner, { if (onSuccess != null ) onSuccess(it) })
        this.onError.observe(owner, { if (onError != null ) onError(it) })
        this.onCanceled.observe(owner, { if(onCanceled != null) onCanceled() })

        this.isLoading.observe(owner, {
            if (it == true && onStart != null) onStart()
            if (it == false && isTriggered.value == true){
                isTriggered.postValue(false)
                onComplete?.invoke()
            }
        })
    }

    fun refresh() {
        if (isExecuted) {
            isTriggered.postValue(true)
            isLoading.postValue(true)
            executable.postValue(executable.value)
        }
    }

    private var isExecuted = false

    fun get(param: P, isSingleRequest: Boolean = false) {
        Log.d("ANGGA", "get: $param ")
        if (!isSingleRequest || !isExecuted) {
            isTriggered.postValue(true)
            isLoading.postValue(true)
            executable.postValue(param!!)
            isExecuted = true
        }
    }

    private val execution : LiveData<StatefulResult<R>>
        get() = executionMutable



    val executionMutable : MediatorLiveData<StatefulResult<R>> = MediatorLiveData()


    init {
        onSuccess.addSource(execution){
            if (it is StatefulResult.Success){
                onSuccess.postValue(it.data!!)
            }
        }

        onError.addSource(execution) {
            if (it is StatefulResult.Failed) {
                onError.postValue(it.error!!)
                isLoading.postValue(false)
                statefulResultLiveData.postValue(it)
            }
        }

        executionMutable.addSource(executable) {
            executor.execute(coroutineScope, it, executionMutable::postValue)
        }
    }
}