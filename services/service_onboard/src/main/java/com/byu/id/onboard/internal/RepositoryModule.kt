package com.byu.id.onboard.internal

import com.byu.id.onboard.data.webservice.mapper.OnboardingResultDtoMapper
import com.byu.id.onboard.data.webservice.mapper.PartialMaintenanceContentListDtoMapper
import com.byu.id.onboard.data.webservice.mapper.StatusResultDtoMapper
import com.byu.id.onboard.data.webservice.repository.OnboardStatusRepositoryImpl
import com.byu.id.onboard.data.webservice.service.OnboardService
import com.byu.id.onboard.domain.repository.OnboardServiceRepository
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
    fun providesOnboardRepository(onboardService : OnboardService) : OnboardServiceRepository {

        val partialMaintenanceContentListDtoMapper = PartialMaintenanceContentListDtoMapper()
        val statusResultDtoMapper = StatusResultDtoMapper(partialMaintenanceContentListDtoMapper)

        return OnboardStatusRepositoryImpl(
            onboardService,
            onboardingResultDtoMapper = OnboardingResultDtoMapper(statusResultDtoMapper)
        )
    }
}