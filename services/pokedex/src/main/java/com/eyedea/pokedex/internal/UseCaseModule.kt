package com.eyedea.pokedex.internal

import com.eyedea.pokedex.domain.repository.PokedexRepository
import com.eyedea.pokedex.domain.usecase.GetPokedexListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providesPokedexApiUseCase(repository : PokedexRepository) : GetPokedexListUseCase = GetPokedexListUseCase(repository)
}