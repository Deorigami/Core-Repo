package com.eyedea.pokedex.internal

import com.eyedea.pokedex.data.webservice.service.PokedexAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesPokedexApi(retrofit : Retrofit) : PokedexAPI = retrofit.create(PokedexAPI::class.java)
}