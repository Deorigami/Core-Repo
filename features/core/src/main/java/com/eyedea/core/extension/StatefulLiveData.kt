package com.eyedea.core.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.eyedea.core.base.BaseUseCase
import com.eyedea.core.model.Error
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

    private val execution : LiveData<StatefulResult<R>>
        get() = executionMutable

    val executionMutable : MediatorLiveData<StatefulResult<R>> = MediatorLiveData()


    init {
        onSuccess.addSource(execution){
            if (it is StatefulResult.Success){
                onSuccess.postValue(it.data)

            }
        }
    }
}