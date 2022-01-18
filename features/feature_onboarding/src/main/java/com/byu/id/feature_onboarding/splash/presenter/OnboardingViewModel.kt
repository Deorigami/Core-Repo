package com.byu.id.feature_onboarding.splash.presenter

import androidx.lifecycle.viewModelScope
import com.byu.id.core.base.BaseViewModel
import com.byu.id.core.extension.StatefulLiveData
import com.byu.id.feature_onboarding.splash.SplashScreenContract
import com.byu.id.onboard.domain.usecase.OnboardingStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    onboardingStatusUseCase: OnboardingStatusUseCase
) : BaseViewModel(), SplashScreenContract.Presenter {
    override fun getKillableStatefulLiveData(): List<StatefulLiveData<*, *>> {
        return listOf()
    }

    override val onboardingStatus = StatefulLiveData(
        onboardingStatusUseCase,
        viewModelScope
    )

}