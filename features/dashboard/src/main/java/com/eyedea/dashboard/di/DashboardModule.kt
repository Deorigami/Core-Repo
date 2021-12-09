package com.eyedea.dashboard.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object DashboardModule {
    @Provides
    @Named("TestFromDashboard")
    fun providesFromDashboard() : String = "this is from module dashboard"
}