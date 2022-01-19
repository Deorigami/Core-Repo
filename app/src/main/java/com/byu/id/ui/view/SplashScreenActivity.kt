package com.byu.id.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.byu.id.R
import com.byu.id.core.base.BaseActivity
import com.byu.id.feature_onboarding.onboarding.view.OnboardingActivity
import com.byu.id.ui.presenter.SplashViewModel


class SplashScreenActivity(
    layout: Int = R.layout.activity_base_fragment
) : BaseActivity(layout) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val fragment = SplashScreenPage()
        fragment.arguments = intent.extras
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragment, fragment)
            .commit()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

    }

}