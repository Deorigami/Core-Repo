package com.byu.id.onboard.domain.repository

import com.byu.id.core.model.Result
import com.byu.id.onboard.domain.entity.OnboardingStatusEntity

interface OnboardServiceRepository {
    suspend fun getOnboardService() : Result<OnboardingStatusEntity>
}