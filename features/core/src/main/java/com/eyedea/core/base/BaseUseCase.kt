package com.eyedea.core.base

import com.eyedea.core.BuildConfig
import com.eyedea.core.extension.StatefulResponse
import com.eyedea.core.extension.StatefulResult
import com.eyedea.core.model.Error
import com.eyedea.core.model.Result
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.forgerock.android.auth.exception.ApiException
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

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
            onResult(
                either {
                    build(param)
                }.toResult()
            )
        }
    }

    fun cancel(){
        job?.cancel()
    }

    suspend fun <V> either(block: suspend () -> Result<V>): StatefulResponse<V> = runCatching {
        StatefulResponse.Success(block())
    }.getOrElse {
        StatefulResponse.Error(it)
    }

    fun <T> StatefulResponse<T>.toResult(): StatefulResult<T> = when {
        this is StatefulResponse.Error -> StatefulResult.Failed(this.exception.toError())
        this is StatefulResponse.Success && this.data != null -> StatefulResult.Success(this.data.data!!)
        else -> StatefulResult.Failed(Error("512", "No Data"))
    }

    fun Throwable.toError(): Error {
        if (BuildConfig.DEBUG) {
            printStackTrace()
        }
        return when (this) {
            is SocketTimeoutException, is InterruptedIOException, is UnknownHostException, is ConnectException -> Error("NO INTERNET", this.message?: this::class.java.simpleName)
            is ApiException -> Error(this.statusCode.toString(), this.message ?: this::class.java.simpleName)
            is Exception -> Error("NO DATA", this.localizedMessage ?: this::class.java.simpleName)
            else -> Error("", this.message ?: this::class.java.simpleName)
        }
    }
}