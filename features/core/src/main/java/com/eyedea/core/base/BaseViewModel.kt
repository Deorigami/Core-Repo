package com.eyedea.core.base

import androidx.lifecycle.ViewModel
import com.eyedea.core.extension.StatefulLiveData

abstract class BaseViewModel : ViewModel() {

    override fun onCleared() {
        val killables = getKillableStatefulLiveData()
        killables.forEach {
            it.cancel()
        }

        super.onCleared()
    }

    abstract fun getKillableStatefulLiveData(): List<StatefulLiveData<*, *>>
}