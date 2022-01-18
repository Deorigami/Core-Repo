package com.byu.id.core.extension

import com.byu.id.core.model.Result
import com.byu.id.core.model.ResultDto

fun <T> ResultDto<*>.toResult(data: T?): Result<T> {
    return Result(
        data = data,
        message = this.message,
        code = this.code ?: 0,
        status = this.status ?: 0
    )
}