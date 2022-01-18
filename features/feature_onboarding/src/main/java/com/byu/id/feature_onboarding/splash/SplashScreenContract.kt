package com.byu.id.feature_onboarding.splash

import com.byu.id.core.extension.StatefulLiveData
import com.byu.id.onboard.domain.entity.OnboardingStatusEntity

interface SplashScreenContract {

    interface Presenter {
        val onboardingStatus : StatefulLiveData<Unit, OnboardingStatusEntity>
    }
}