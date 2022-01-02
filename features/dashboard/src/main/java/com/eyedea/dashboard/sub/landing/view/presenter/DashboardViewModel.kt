package com.eyedea.dashboard.sub.landing.view.presenter

import androidx.lifecycle.viewModelScope
import com.eyedea.core.base.BaseViewModel
import com.eyedea.core.extension.StatefulLiveData
import com.eyedea.dashboard.sub.landing.DashboardLandingContract
import com.eyedea.pokedex.domain.entity.PokedexListEntity
import com.eyedea.pokedex.domain.usecase.GetPokedexListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    getPokedexListUseCase: GetPokedexListUseCase
) : BaseViewModel(), DashboardLandingContract.Presenter {
    override fun getKillableStatefulLiveData(): List<StatefulLiveData<*, *>> {
        return listOf()
    }

    override val pokedexList = StatefulLiveData(
        getPokedexListUseCase,
        viewModelScope
    )

}