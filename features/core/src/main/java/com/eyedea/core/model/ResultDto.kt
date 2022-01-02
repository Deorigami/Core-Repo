package com.eyedea.core.model

import com.google.gson.annotations.SerializedName

class ResultDto<T>(
    @SerializedName("data")
    val data: T? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("code")
    val code: String? = null
) {
    companion object {
        const val SUCCESS = "000"
    }
}