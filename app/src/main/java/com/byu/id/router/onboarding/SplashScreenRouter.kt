package com.byu.id.router.onboarding

import android.app.Activity
import android.content.Intent
import com.byu.id.core.base.BaseRouter
import com.byu.id.feature_onboarding.onboarding.view.OnboardingActivity
import com.byu.id.ui.SplashScreenContract

class SplashScreenRouter : BaseRouter(), SplashScreenContract.Router {
    override fun navigateToOnboardingPage(activity : Activity) {
        val intent = Intent(activity, OnboardingActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    override fun navigateToMaintenancePage() {
        TODO("Not yet implemented")
    }

}