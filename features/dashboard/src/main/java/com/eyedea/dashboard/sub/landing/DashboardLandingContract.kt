package com.eyedea.dashboard.sub.landing

import com.eyedea.core.base.BaseRouter
import com.eyedea.core.contract.RouterContract

interface DashboardLandingContract {
    interface View
    interface Presenter
    interface Router : RouterContract {
        fun navigateToPokedexInfo()
    }
}