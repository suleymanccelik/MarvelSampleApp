package com.suleymancelik.marvelapp.list.ui

import com.airbnb.epoxy.EpoxyModelClass
import com.suleymancelik.marvelapp.common.ui.helpers.ViewBindingEpoxyModelWithHolder
import com.suleymancelik.marvelapp.list.R
import com.suleymancelik.marvelapp.list.databinding.LoadingLayoutBinding

@EpoxyModelClass
abstract class LoadingEpoxyModel : ViewBindingEpoxyModelWithHolder<LoadingLayoutBinding>() {

    override fun getDefaultLayout(): Int = R.layout.loading_layout

    override fun LoadingLayoutBinding.bind() {

    }
}
