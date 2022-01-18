package com.byu.id.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.byu.id.R
import com.byu.id.core.base.BaseActivity
import com.byu.id.feature_onboarding.onboarding.view.OnboardingActivity
import com.byu.id.ui.SplashScreenContract
import com.byu.id.ui.presenter.SplashViewModel
import javax.inject.Inject


class SplashScreenActivity(
    layout: Int = R.layout.activity_splash_screen
) : BaseActivity(layout) {

    private val viewModel : SplashViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        getData()
        setObserver()
    }

    private fun setObserver(){
        viewModel.run {
            onboardingStatus.listen(
                this@SplashScreenActivity,
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

    private fun getData(){
        viewModel.onboardingStatus.get(Unit)
    }

    private fun navigateToOnboard(){
        val intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
        finish()
    }

}