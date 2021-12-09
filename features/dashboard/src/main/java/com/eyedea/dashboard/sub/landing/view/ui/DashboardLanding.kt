package com.eyedea.dashboard.sub.landing.view.ui

import android.view.View
import com.eyedea.core.base.BaseViewBindingFragment
import com.eyedea.core.contract.RouterContract
import com.eyedea.dashboard.R
import com.eyedea.dashboard.databinding.PageDashboardLandingBinding
import com.eyedea.dashboard.sub.landing.DashboardLandingContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardLanding(
    override val layout: Int = R.layout.page_dashboard_landing
) : BaseViewBindingFragment<PageDashboardLandingBinding>() {

    //Router
    // -----------------------------------------------

    @Inject override lateinit var router: DashboardLandingContract.Router

    override fun initBinding(view: View) {
        binding = PageDashboardLandingBinding.bind(view)
    }

    override fun didMount(view: View) {
        super.didMount(view)

        binding?.apply {
            textViewDasboard.apply {
                text = "ini dari dashboard module"
            }
            buttonView.setOnClickListener {
                router.navigateToPokedexInfo()
            }
        }
    }
}