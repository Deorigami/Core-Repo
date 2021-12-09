package com.eyedea.pokedex.data.webservice.repository

import com.eyedea.pokedex.data.webservice.mapper.PokedexResponseDtoMapper
import com.eyedea.pokedex.data.webservice.service.PokedexAPI
import com.eyedea.pokedex.domain.entity.PokedexListEntity
import com.eyedea.pokedex.domain.repository.PokedexRepository

class PokedexRepositoryImpl (
    private val pokedexAPI: PokedexAPI,
    private val pokedexResponseDtoMapper: PokedexResponseDtoMapper
) : PokedexRepository{
    override suspend fun getPokedexList(): PokedexListEntity {
        return pokedexResponseDtoMapper(
            pokedexAPI.getPokemonList()
        )
    }
}