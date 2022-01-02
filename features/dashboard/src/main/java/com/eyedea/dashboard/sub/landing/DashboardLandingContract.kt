package com.eyedea.dashboard.sub.landing

import com.eyedea.core.base.BaseRouter
import com.eyedea.core.contract.RouterContract
import com.eyedea.core.extension.StatefulLiveData
import com.eyedea.pokedex.domain.entity.PokedexListEntity

interface DashboardLandingContract {
    interface View
    interface Presenter {
        val pokedexList : StatefulLiveData<Unit, PokedexListEntity>
    }
    interface Router : RouterContract {
        fun navigateToPokedexInfo()
    }
}