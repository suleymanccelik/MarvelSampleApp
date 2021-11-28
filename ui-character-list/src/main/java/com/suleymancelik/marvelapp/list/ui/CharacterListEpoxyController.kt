package com.suleymancelik.marvelapp.list.ui

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.suleymancelik.marvelapp.data.CharacterListResult

/**
 * EpoxyController which works with PagedLists
 */
class CharacterListEpoxyController : PagedListEpoxyController<CharacterListResult>() {

    private var isError: Boolean = false

    var error: String? = ""
        set(value) {
            field = value?.let {
                isError = true
                it
            } ?: run {
                isError = false
                null
            }
            if (isError) {
                requestModelBuild()
            }
        }

    var isLoading = false
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }


    /**
     * Adding models
     */
    override fun addModels(models: List<EpoxyModel<*>>) {
        when {
            isError -> {
                super.addModels(
                    models.plus(
                        //Error View Model
                        ErrorEpoxyModel_()
                            .id("Error")
                            .errorStr(error)
                    ).filter { !(it is LoadingEpoxyModel_) }
                )
            }
            isLoading -> {
                super.addModels(
                    models.plus(
                        //Error View Model
                        LoadingEpoxyModel_()
                            .id("loading")
                    ).distinct()
                )
            }
            else -> {
                super.addModels(models.distinct())
            }
        }
    }

    override fun onExceptionSwallowed(exception: RuntimeException) {

    }

    override fun buildItemModel(
        currentPosition: Int,
        item: CharacterListResult?
    ): EpoxyModel<*> {
        item?.let {
            //Movie Item View Model
            return CharacterItemModel_()
                .id("character${currentPosition}")
                .title(item.name ?: "Unknown")
                .description(item.description ?: "Uknown")
                .thumbnailUrl(item.comicsThumbnail.path.replace("http","https") + "/standard_large." + item.comicsThumbnail.extension)


        } ?: run {
            //Loading View Model
            return LoadingEpoxyModel_()
                .id("loading")
        }
    }
}
