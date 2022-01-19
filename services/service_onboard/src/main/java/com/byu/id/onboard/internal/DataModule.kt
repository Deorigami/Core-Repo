package com.byu.id.onboard.internal

import com.byu.id.onboard.data.webservice.service.OnboardService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun providesRetrofit(retrofit: Retrofit) : OnboardService = retrofit.create(OnboardService::class.java)
}