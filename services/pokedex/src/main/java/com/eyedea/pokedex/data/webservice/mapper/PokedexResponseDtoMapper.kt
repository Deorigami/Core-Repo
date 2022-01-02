package com.eyedea.pokedex.data.webservice.mapper

import com.eyedea.core.extension.toResult
import com.eyedea.core.model.Result
import com.eyedea.pokedex.data.webservice.dto.PokedexResultDto
import com.eyedea.pokedex.domain.entity.PokedexListEntity

class PokedexResponseDtoMapper(
    private val pokemonListMapper: PokemonListMapper
) {
    operator fun invoke(from : PokedexResultDto) : Result<PokedexListEntity> {
        return Result(
            data = PokedexListEntity(
                from.count,
                from.next,
                from.previous,
                pokemonListMapper.invoke(from)
            )
        )
    }
}