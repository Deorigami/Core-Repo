package com.byu.id.onboard.data.webservice.repository

import com.byu.id.core.model.Result
import com.byu.id.onboard.data.webservice.mapper.OnboardingResultDtoMapper
import com.byu.id.onboard.data.webservice.service.OnboardService
import com.byu.id.onboard.domain.entity.OnboardingStatusEntity
import com.byu.id.onboard.domain.repository.OnboardServiceRepository

class OnboardStatusRepositoryImpl(
    private val onboardService : OnboardService,
    private val onboardingResultDtoMapper: OnboardingResultDtoMapper
) : OnboardServiceRepository {

    override suspend fun getOnboardService(): Result<OnboardingStatusEntity> {
        return onboardingResultDtoMapper(onboardService.getOnboardStatus())
    }

}