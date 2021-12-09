package com.eyedea.testmultimodule.router.dashboard

import com.eyedea.core.base.BaseRouter
import com.eyedea.dashboard.sub.landing.DashboardLandingContract
import com.eyedea.testmultimodule.R

class DashboardLandingRouter : BaseRouter(), DashboardLandingContract.Router {
    override fun navigateToPokedexInfo() {
        push(R.id.pokedex_info_nav)
    }

}