package com.byu.id.ui.presenter

import androidx.lifecycle.viewModelScope
import com.byu.id.core.base.BaseViewModel
import com.byu.id.core.extension.StatefulLiveData
import com.byu.id.onboard.domain.usecase.OnboardingStatusUseCase
import com.byu.id.ui.SplashScreenContract
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    onboardingStatusUseCase: OnboardingStatusUseCase
) : BaseViewModel(), SplashScreenContract.Presenter{
    override fun getKillableStatefulLiveData(): List<StatefulLiveData<*, *>> {
        return listOf()
    }

    override val onboardingStatus = StatefulLiveData(
        onboardingStatusUseCase,
        viewModelScope
    )
}