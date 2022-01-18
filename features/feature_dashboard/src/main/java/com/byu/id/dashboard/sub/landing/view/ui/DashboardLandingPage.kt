package com.byu.id.dashboard.sub.landing.view.ui

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.byu.id.core.base.BaseViewBindingFragment
import com.byu.id.dashboard.R
import com.byu.id.dashboard.databinding.PageDashboardLandingBinding
import com.byu.id.dashboard.sub.landing.DashboardLandingContract
import com.byu.id.dashboard.sub.landing.view.presenter.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardLandingPage(
    override val layout: Int = R.layout.page_dashboard_landing
) : BaseViewBindingFragment<PageDashboardLandingBinding>() {

    // Router
    // -----------------------------------------------

    @Inject override lateinit var router: DashboardLandingContract.Router



    override fun initBinding(view: View) {
        binding = PageDashboardLandingBinding.bind(view)
    }

    override fun didMount(view: View) {
        super.didMount(view)

        binding?.apply {
            textViewDasboard.apply {

            }
            buttonView.setOnClickListener {
                router.navigateToPokedexInfo()
            }
        }

        initObserver()
        getData()
    }

    private fun initObserver(){

    }

    private fun getData(){

    }
}