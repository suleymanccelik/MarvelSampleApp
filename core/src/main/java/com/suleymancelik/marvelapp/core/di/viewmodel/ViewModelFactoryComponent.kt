package com.suleymancelik.marvelapp.core.di.viewmodel

import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        ViewModelFactoryModule::class
    ]
)
interface ViewModelFactoryComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance viewModelInject: FactoriesMap
        ): ViewModelFactoryComponent
    }

    companion object {
        private var instance: ViewModelFactoryComponent? = null

        fun storeInstance(instance: ViewModelFactoryComponent) {
            Companion.instance = instance
        }

        fun getInstance(): ViewModelFactoryComponent {
            require(instance != null) {
                "AppComponent requested without being initialized first. Call initAppComponent() before" +
                        "requesting an instance."
            }
            return instance!!
        }
    }

    fun provideViewModelFactories(): FactoriesMap
}