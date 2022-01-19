package com.byu.id.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.byu.id.core.contract.RouterContract
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseViewBindingFragment<VB : ViewBinding> : Fragment(), Binding {

    /**
    * DATA
    * */

    open var binding : VB ? = null
    abstract val layout: Int
    private var rootView: View? = null
    protected var hasInitializedRootView = false
    open var useSaveViewState = false
    open var useDefaultThemeResolver = true

    // Router
    open val router : RouterContract ? = null

    /**
    * Lifecycles
    * */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        didMount(view)
        didMount(view, savedInstanceState)

        router?.initiate(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout, container, false)
    }

    /**
    * METHODS
    * */

    open fun didMount(view: View){
        initBinding(view)
    }


    open fun didMount(view: View, savedInstanceState: Bundle?){

    }
}