package com.eyedea.pokedex.domain.entity

data class PokedexListEntity(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Result>
) {
    data class Result(
        val name: String,
        val url: String
    )

    companion object {
        val DEFAULT = PokedexListEntity(
            0,
            "",
            "",
            emptyList()
        )
    }
}