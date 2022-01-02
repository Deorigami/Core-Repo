package com.eyedea.core.extension

import com.eyedea.core.model.Result
import com.eyedea.core.model.ResultDto

fun <T> toResult(data: T?): Result<T> {
    return Result(data)
}