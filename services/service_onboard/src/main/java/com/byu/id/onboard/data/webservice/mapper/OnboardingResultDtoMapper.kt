package com.byu.id.onboard.data.webservice.mapper

import com.byu.id.core.extension.toResult
import com.byu.id.core.model.Result
import com.byu.id.core.model.ResultDto
import com.byu.id.onboard.data.webservice.dto.OnboardingStatusResultDto
import com.byu.id.onboard.domain.entity.OnboardingStatusEntity

class OnboardingResultDtoMapper(
    private val statusResultListMapper : StatusResultDtoMapper
) {
    operator fun invoke(from : ResultDto<OnboardingStatusResultDto>) : Result<OnboardingStatusEntity> {
        return from.toResult(from.data?.let {
            OnboardingStatusEntity(
                status = statusResultListMapper(it.status)
                // TODO
            )
        })
    }
}
