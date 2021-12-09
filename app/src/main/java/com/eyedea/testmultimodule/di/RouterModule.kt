package com.eyedea.testmultimodule.di

import com.eyedea.dashboard.sub.landing.DashboardLandingContract
import com.eyedea.testmultimodule.router.dashboard.DashboardLandingRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RouterModule {

    @Provides
    @Singleton
    fun provideDashboardLandingRouter() : DashboardLandingContract.Router = DashboardLandingRouter()
}