package com.byu.id

import android.view.View
import androidx.navigation.fragment.findNavController
import com.byu.id.core.base.BaseViewBindingFragment
import com.eyedea.testmultimodule.R
import com.eyedea.testmultimodule.databinding.FragmentMainBinding

class MainFragment(
    override val layout: Int = R.layout.fragment_main
) : BaseViewBindingFragment<FragmentMainBinding>() {

    override fun initBinding(view: View) {
        binding = FragmentMainBinding.bind(view)

    }

    override fun didMount(view: View) {
        super.didMount(view)
        findNavController().navigate(R.id.navigateToDashboard)
    }
}