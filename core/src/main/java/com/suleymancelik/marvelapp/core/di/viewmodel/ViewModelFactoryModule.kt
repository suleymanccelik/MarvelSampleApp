package com.suleymancelik.marvelapp.core.di.viewmodel

import dagger.Module
import dagger.Provides
import com.suleymancelik.marvelapp.core.di.MvRxViewModel

@Module
class ViewModelFactoryModule {

    @Provides
    fun provideMap(viewModelFactoryMap: Map<Class<out MvRxViewModel<*>>, AssistedViewModelFactory<*, *>>):
            Map<Class<out MvRxViewModel<*>>, AssistedViewModelFactory<*, *>> = viewModelFactoryMap
}