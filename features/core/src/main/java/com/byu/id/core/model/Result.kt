package com.byu.id.core.model

class Result<T>(
    val data : T? = null,
    val message : String? = null,
    val status : Int? = null,
    val code : Int? = null
)