package com.eyedea.core.contract

import androidx.fragment.app.Fragment

interface RouterContract {
    fun initiate(fragment : Fragment, isTransitionFromBottom : Boolean = false)
}