package com.byu.id.ui

import android.app.Activity
import android.content.Context
import com.byu.id.core.base.BaseRouter
import com.byu.id.core.contract.RouterContract
import com.byu.id.core.extension.StatefulLiveData
import com.byu.id.onboard.domain.entity.OnboardingStatusEntity

interface SplashScreenContract {
    interface Presenter {
        val onboardingStatus : StatefulLiveData<Unit, OnboardingStatusEntity>
    }

    interface Router : RouterContract {
        fun navigateToOnboardingPage(activity : Activity)
        fun navigateToMaintenancePage()
    }
}