package com.suleymancelik.marvelapp.core.di.viewmodel

import com.airbnb.mvrx.MavericksState
import com.suleymancelik.marvelapp.core.di.MvRxViewModel

interface AssistedViewModelFactory<VM: MvRxViewModel<S>, S: MavericksState> {
    fun create(state: S): VM
}


typealias FactoriesMap = Map<Class<out MvRxViewModel<*>>, AssistedViewModelFactory<*, *>>