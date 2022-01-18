package com.byu.id.onboard.domain.usecase

import com.byu.id.core.base.BaseUseCase
import com.byu.id.core.model.Result
import com.byu.id.onboard.domain.entity.OnboardingStatusEntity
import com.byu.id.onboard.domain.repository.OnboardServiceRepository

class OnboardingStatusUseCase(
    private val repository : OnboardServiceRepository
) : BaseUseCase<Unit, OnboardingStatusEntity>() {
    override val default: OnboardingStatusEntity
        get() = OnboardingStatusEntity.DEFAULT

    override suspend fun build(param: Unit): Result<OnboardingStatusEntity> {
        return repository.getOnboardService()
    }
}