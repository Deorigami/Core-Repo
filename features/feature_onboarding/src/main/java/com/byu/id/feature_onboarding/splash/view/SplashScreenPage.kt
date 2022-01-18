package com.byu.id.feature_onboarding.splash.view

import android.view.View
import androidx.fragment.app.activityViewModels
import com.byu.id.core.base.BaseViewBindingFragment
import com.byu.id.feature_onboarding.R
import com.byu.id.feature_onboarding.databinding.PageSplashScreenBinding
import com.byu.id.feature_onboarding.splash.presenter.OnboardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenPage(
    override val layout: Int = R.layout.page_splash_screen
) : BaseViewBindingFragment<PageSplashScreenBinding>() {

    private val viewModel : OnboardingViewModel by activityViewModels()

    override fun initBinding(view: View) {
        binding = PageSplashScreenBinding.bind(view)
    }
}