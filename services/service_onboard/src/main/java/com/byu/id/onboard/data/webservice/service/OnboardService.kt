package com.byu.id.onboard.data.webservice.service

import com.byu.id.core.model.ResultDto
import com.byu.id.onboard.data.webservice.dto.OnboardingStatusResultDto
import retrofit2.http.GET

interface OnboardService {

    @GET("init/status")
    suspend fun getOnboardStatus() : ResultDto<OnboardingStatusResultDto>
}