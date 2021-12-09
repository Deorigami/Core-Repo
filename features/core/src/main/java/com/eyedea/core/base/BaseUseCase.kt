package com.eyedea.core.base

import com.eyedea.core.extension.StatefulResult
import com.eyedea.core.model.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseUseCase <P, R> {
    abstract val default : R
    private var job: Job? = null

    abstract suspend fun build(param : P) : Result<R>

    fun execute(
        coroutineScope: CoroutineScope,
        param : P,
        onResult : (StatefulResult<R>) -> Unit
    ){
        job = coroutineScope.launch {

        }
    }

    fun cancel(){
        job?.cancel()
    }
}