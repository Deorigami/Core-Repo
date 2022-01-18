package com.byu.id.router.dashboard

import com.byu.id.core.base.BaseRouter
import com.byu.id.dashboard.sub.landing.DashboardLandingContract
import com.eyedea.testmultimodule.R

class DashboardLandingRouter : BaseRouter(), DashboardLandingContract.Router {
    override fun navigateToPokedexInfo() {
        push(R.id.pokedex_info_nav)
    }

}