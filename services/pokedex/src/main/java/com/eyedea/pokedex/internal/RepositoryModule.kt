package com.eyedea.pokedex.internal

import com.eyedea.pokedex.data.webservice.mapper.PokedexResponseDtoMapper
import com.eyedea.pokedex.data.webservice.mapper.PokemonListMapper
import com.eyedea.pokedex.data.webservice.repository.PokedexRepositoryImpl
import com.eyedea.pokedex.data.webservice.service.PokedexAPI
import com.eyedea.pokedex.domain.repository.PokedexRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesPokedexRepositoryImpl(pokedexAPI: PokedexAPI) : PokedexRepository {
        val pokemonListMapper = PokemonListMapper()
        return PokedexRepositoryImpl(
            pokedexAPI,
            PokedexResponseDtoMapper(pokemonListMapper)
        )
    }
}