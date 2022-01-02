package com.eyedea.pokedex.data.webservice.service

import com.eyedea.core.model.ResultDto
import com.eyedea.pokedex.data.webservice.dto.PokedexResultDto
import retrofit2.http.GET

interface PokedexAPI {
    @GET("pokemon")
    suspend fun getPokemonList() : PokedexResultDto
}