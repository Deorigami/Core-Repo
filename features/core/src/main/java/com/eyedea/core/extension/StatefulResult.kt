package com.eyedea.core.extension

sealed class StatefulResult<out T> {
    val succeeded
        get() = this is Success && data != null


    data class Success<out T>(val data : T) : StatefulResult<T>()
    data class Failed(val error: Error? = null) : StatefulResult<Nothing>()
    object Loading : StatefulResult<Nothing>()

}
