package com.byu.id.dashboard.sub.landing

import com.byu.id.core.contract.RouterContract
import com.byu.id.core.extension.StatefulLiveData

interface DashboardLandingContract {
    interface View
    interface Presenter {

    }
    interface Router : RouterContract {
        fun navigateToPokedexInfo()
    }
}