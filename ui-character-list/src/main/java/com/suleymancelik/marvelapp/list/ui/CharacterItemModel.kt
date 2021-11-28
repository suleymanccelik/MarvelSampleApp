package com.suleymancelik.marvelapp.list.ui

import android.view.View
import coil.load
import com.airbnb.epoxy.*
import com.suleymancelik.marvelapp.common.ui.helpers.ViewBindingEpoxyModelWithHolder
import com.suleymancelik.marvelapp.list.R
import com.suleymancelik.marvelapp.list.databinding.ItemLayoutCharacterBinding
import timber.log.Timber

@EpoxyModelClass
abstract class CharacterItemModel : ViewBindingEpoxyModelWithHolder<ItemLayoutCharacterBinding>() {

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute
    lateinit var description: String

    @EpoxyAttribute
    lateinit var thumbnailUrl: String

    override fun getDefaultLayout(): Int = R.layout.item_layout_character

    override fun ItemLayoutCharacterBinding.bind() {
        if (title == "loading") {
            movieTitle.text = title
            movieDescription.visibility = View.GONE
            movieThumbnail.visibility = View.GONE
        } else {
            movieDescription.visibility = View.VISIBLE
            movieThumbnail.visibility = View.VISIBLE

            movieTitle.text = title
            movieDescription.text = description

            Timber.e("title $title logo $thumbnailUrl")

            movieThumbnail.load(thumbnailUrl) {
                placeholder(R.drawable.placeholder)
                error(R.drawable.placeholder)
            }
        }
    }
}
