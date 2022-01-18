package com.byu.id.info.sub.infolanding.view

import android.view.View
import com.byu.id.core.base.BaseViewBindingFragment
import com.byu.id.info.R
import com.byu.id.info.databinding.PagePokedexInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokedexInfoPage(
    override val layout: Int = R.layout.page_pokedex_info
) : BaseViewBindingFragment<PagePokedexInfoBinding>() {

    override fun initBinding(view: View) {
        binding = PagePokedexInfoBinding.bind(view)
    }


}