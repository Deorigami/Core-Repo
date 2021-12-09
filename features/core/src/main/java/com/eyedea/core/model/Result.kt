package com.eyedea.core.model

class Result<T>(
    val data : T? = null,
    val message : String? = null,
    val status : String = "INNITIATE",
    val code : String = "XXX"
)