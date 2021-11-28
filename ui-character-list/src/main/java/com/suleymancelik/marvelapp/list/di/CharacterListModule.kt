package com.suleymancelik.marvelapp.list.di

import com.suleymancelik.marvelapp.core.di.viewmodel.AssistedViewModelFactory
import com.suleymancelik.marvelapp.core.di.viewmodel.ViewModelKey
import com.suleymancelik.marvelapp.list.CharacterListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CharacterListModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    fun characterListViewModelFactory(factory: CharacterListViewModel.Factory): AssistedViewModelFactory<*, *>

}