package com.suleymancelik.marvelapp.di

import com.suleymancelik.marvelapp.BaseApplication
import com.suleymancelik.marvelapp.core.di.CoreComponent
import com.suleymancelik.marvelapp.core.di.viewmodel.FactoriesMap
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        ActivityBuilder::class,
        AppModule::class,
        AndroidSupportInjectionModule::class
    ],
    dependencies = [CoreComponent::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: BaseApplication,
            coreComponent: CoreComponent
        ): AppComponent
    }

    fun viewModelFactories(): FactoriesMap
}