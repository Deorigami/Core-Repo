package com.byu.id.di

import com.byu.id.dashboard.sub.landing.DashboardLandingContract
import com.byu.id.router.dashboard.DashboardLandingRouter
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