package com.byu.id.feature_onboarding.onboarding.view

import android.os.Bundle
import com.byu.id.core.base.BaseActivity
import com.byu.id.feature_onboarding.R

class OnboardingActivity(
   layout : Int = R.layout.activity_onboarding
) : BaseActivity(layout){

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_onboarding)
   }
}