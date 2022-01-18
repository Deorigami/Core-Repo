package com.byu.id.dashboard.sub.landing.view.presenter

import androidx.lifecycle.viewModelScope
import com.byu.id.core.base.BaseViewModel
import com.byu.id.core.extension.StatefulLiveData
import com.byu.id.dashboard.sub.landing.DashboardLandingContract
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(

) : BaseViewModel(), DashboardLandingContract.Presenter {
    override fun getKillableStatefulLiveData(): List<StatefulLiveData<*, *>> {
        return listOf()
    }



}