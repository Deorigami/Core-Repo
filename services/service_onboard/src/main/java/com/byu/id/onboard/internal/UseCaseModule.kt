package com.byu.id.onboard.internal

import com.byu.id.onboard.domain.repository.OnboardServiceRepository
import com.byu.id.onboard.domain.usecase.OnboardingStatusUseCase
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
    fun providesOnboardingStatusUseCase(repository: OnboardServiceRepository) : OnboardingStatusUseCase = OnboardingStatusUseCase(repository)
}