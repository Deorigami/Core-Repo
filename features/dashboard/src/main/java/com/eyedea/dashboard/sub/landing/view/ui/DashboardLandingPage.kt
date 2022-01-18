package com.eyedea.dashboard.sub.landing.view.ui

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.eyedea.core.base.BaseViewBindingFragment
import com.eyedea.core.contract.RouterContract
import com.eyedea.dashboard.R
import com.eyedea.dashboard.databinding.PageDashboardLandingBinding
import com.eyedea.dashboard.sub.landing.DashboardLandingContract
import com.eyedea.dashboard.sub.landing.view.presenter.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class DashboardLandingPage(
    override val layout: Int = R.layout.page_dashboard_landing
) : BaseViewBindingFragment<PageDashboardLandingBinding>() {

    // Router
    // -----------------------------------------------

    @Inject override lateinit var router: DashboardLandingContract.Router

    private val viewModel : DashboardViewModel by viewModels()

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
        viewModel.run {
            pokedexList.listen(
                viewLifecycleOwner,
                onSuccess = {
                    Log.d("ANGGA", "$it")
                },
                onError = {
                    Log.d("ANGGA", "initObserver: $it")
                },
                onComplete = {
                    Log.d("ANGGA", "COMPLETE")
                }
            )
        }
    }

    private fun getData(){
        Log.d("ANGGA", "getData:")
        viewModel.pokedexList.get(Unit)
    }
}