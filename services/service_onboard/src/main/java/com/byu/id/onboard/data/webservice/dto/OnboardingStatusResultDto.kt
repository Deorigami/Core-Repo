package com.byu.id.onboard.data.webservice.dto

data class OnboardingStatusResultDto(
    val status: List<StatusDto>,
    val version: List<Any>
)