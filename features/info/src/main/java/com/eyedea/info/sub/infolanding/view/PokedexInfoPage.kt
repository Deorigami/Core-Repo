package com.eyedea.info.sub.infolanding.view

import android.view.View
import com.eyedea.core.base.BaseViewBindingFragment
import com.eyedea.info.R
import com.eyedea.info.databinding.PagePokedexInfoBinding

class PokedexInfoPage(
    override val layout: Int = R.layout.page_pokedex_info
) : BaseViewBindingFragment<PagePokedexInfoBinding>() {

    override fun initBinding(view: View) {
        binding = PagePokedexInfoBinding.bind(view)
    }


}