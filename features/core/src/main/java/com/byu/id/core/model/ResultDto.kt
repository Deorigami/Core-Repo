package com.byu.id.core.model

import com.google.gson.annotations.SerializedName

class ResultDto<T>(
    @SerializedName("data")
    val data: T? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: Int? = null,
    @SerializedName("code")
    val code: Int? = null
) {
    companion object {
        const val SUCCESS = 0
    }
}