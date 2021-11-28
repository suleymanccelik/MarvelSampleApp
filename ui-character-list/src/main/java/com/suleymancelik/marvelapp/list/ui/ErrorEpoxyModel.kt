package com.suleymancelik.marvelapp.list.ui

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.suleymancelik.marvelapp.common.ui.helpers.ViewBindingEpoxyModelWithHolder
import com.suleymancelik.marvelapp.list.R
import com.suleymancelik.marvelapp.list.databinding.ErrorLayoutBinding

@EpoxyModelClass
abstract class ErrorEpoxyModel : ViewBindingEpoxyModelWithHolder<ErrorLayoutBinding>() {

    @EpoxyAttribute
    var errorStr: String? = null

    override fun getDefaultLayout(): Int = R.layout.error_layout

    override fun ErrorLayoutBinding.bind() {
        errorTv.text = errorStr
    }
}
