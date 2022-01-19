package com.byu.id.ui.view

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.byu.id.R
import com.byu.id.core.base.BaseViewBindingFragment
import com.byu.id.databinding.PageSplashScreenBinding
import com.byu.id.feature_onboarding.onboarding.view.OnboardingActivity
import com.byu.id.ui.SplashScreenContract
import com.byu.id.ui.presenter.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreenPage(
    override val layout: Int = R.layout.page_splash_screen
    ) : BaseViewBindingFragment<PageSplashScreenBinding>() {

    @Inject override lateinit var router : SplashScreenContract.Router

    private val viewModel : SplashViewModel by activityViewModels()

    override fun initBinding(view: View) {
        binding = PageSplashScreenBinding.bind(view)
    }

    override fun didMount(view: View) {
        super.didMount(view)

        initView()
        setObserver()
    }

    private fun initView(){
        getData()
    }

    private fun setObserver(){
        viewModel.run {
            onboardingStatus.listen(
                viewLifecycleOwner,
                onSuccess = { statusEntity ->
                    Log.d("ANGGA", "setObserver: $statusEntity ")
                    val status = statusEntity.status.find { it.platform == "android" }
                    status?.let {
                        if (it.code == 200) navigateToOnboard()
                    }
                },
                onError = {
                    Log.d("ANGGA", "setObserver: $it ")
                },
                onComplete = {
                    Log.d("ANGGA", "complete")
                }
            )
        }
    }

    private fun getData() {
        viewModel.onboardingStatus.get(Unit)
    }

    private fun navigateToOnboard(){
        router.navigateToOnboardingPage(requireActivity())
    }

}