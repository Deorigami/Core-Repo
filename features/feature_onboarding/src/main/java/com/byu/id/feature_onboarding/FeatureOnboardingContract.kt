package com.byu.id.feature_onboarding

import com.byu.id.core.extension.StatefulLiveData
import com.byu.id.onboard.domain.entity.OnboardingStatusEntity

interface FeatureOnboardingContract {

    interface Presenter {
        interface Onboarding {
            val onboardingStatus : StatefulLiveData<Unit, OnboardingStatusEntity>
        }
    }
}