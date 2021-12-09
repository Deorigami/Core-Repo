package com.eyedea.pokedex.data.webservice.mapper

import com.eyedea.pokedex.data.webservice.dto.PokedexResultDto
import com.eyedea.pokedex.domain.entity.PokedexListEntity

class PokedexResponseDtoMapper(
    private val pokemonListMapper: PokemonListMapper
) {
    operator fun invoke(from : PokedexResultDto) : PokedexListEntity {
        return PokedexListEntity(
            count = from.count,
            next = from.next,
            previous = from.previous,
            results = pokemonListMapper.invoke(from)

        )
    }
}