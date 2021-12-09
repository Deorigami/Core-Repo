package com.eyedea.pokedex.domain.repository

import com.eyedea.pokedex.domain.entity.PokedexListEntity

interface PokedexRepository {
    suspend fun getPokedexList() : PokedexListEntity
}