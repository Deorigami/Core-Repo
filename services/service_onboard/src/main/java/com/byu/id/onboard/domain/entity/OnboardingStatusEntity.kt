package com.byu.id.onboard.domain.entity

data class OnboardingStatusEntity(
    val status: List<StatusEntity>,
    val version: List<Any> = emptyList()
) {
    companion object {
        val DEFAULT = OnboardingStatusEntity(
            status = emptyList(),
            version = emptyList()
        )
    }
}