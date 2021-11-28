package com.suleymancelik.marvelapp.core.di.viewmodel

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.suleymancelik.marvelapp.core.di.MvRxViewModel

abstract class DaggerMvRxViewModelFactory<VM : MvRxViewModel<S>, S : MavericksState>(
    private val viewModelClass: Class<out MvRxViewModel<S>>
) : MavericksViewModelFactory<VM, S> {

    override fun create(viewModelContext: ViewModelContext, state: S): VM? {
        return createViewModel(state)
    }

    private fun <VM : MvRxViewModel<S>, S : MavericksState> createViewModel(state: S): VM {
        val viewModelFactoryMap =
            ViewModelFactoryComponent.getInstance().provideViewModelFactories()
        val viewModelFactory = viewModelFactoryMap[viewModelClass]

        @Suppress("UNCHECKED_CAST")
        val castedViewModelFactory = viewModelFactory as? AssistedViewModelFactory<VM, S>
        val viewModel = castedViewModelFactory?.create(state)
        return viewModel as VM
    }
}

