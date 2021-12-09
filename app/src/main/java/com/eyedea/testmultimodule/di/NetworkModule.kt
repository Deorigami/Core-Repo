package com.eyedea.testmultimodule.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.eyedea.testmultimodule.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun profidesOkHTTP(@ApplicationContext context: Context) : OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(ChuckerInterceptor(context))
        .build()

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) : Retrofit = Retrofit
        .Builder()
        .baseUrl(BuildConfig.POKEDEX_URL)
        .client(okHttpClient)
        .build()
}
