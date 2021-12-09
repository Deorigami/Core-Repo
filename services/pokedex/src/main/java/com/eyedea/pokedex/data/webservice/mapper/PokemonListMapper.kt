package com.eyedea.pokedex.data.webservice.mapper

import com.eyedea.pokedex.data.webservice.dto.PokedexResultDto
import com.eyedea.pokedex.domain.entity.PokedexListEntity

class PokemonListMapper  {
    operator fun invoke(from : PokedexResultDto) : List<PokedexListEntity.Result> {
        return from.results.map {
            PokedexListEntity.Result(
                name = it.name,
                url = it.url
            )
        }
    }
}