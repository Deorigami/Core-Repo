package com.eyedea.info.sub.infolanding.view

import android.view.View
import com.eyedea.core.base.BaseViewBindingFragment
import com.eyedea.info.R
import com.eyedea.info.databinding.PagePokedexInfoBinding
import com.eyedea.pokedex.data.webservice.service.PokedexAPI
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PokedexInfoPage(
    override val layout: Int = R.layout.page_pokedex_info
) : BaseViewBindingFragment<PagePokedexInfoBinding>() {

    override fun initBinding(view: View) {
        binding = PagePokedexInfoBinding.bind(view)
    }


}