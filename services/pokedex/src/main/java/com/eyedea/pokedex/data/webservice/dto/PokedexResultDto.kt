package com.eyedea.pokedex.data.webservice.dto

data class PokedexResultDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Result>
){
    data class Result(
        val name: String,
        val url: String
    )
}