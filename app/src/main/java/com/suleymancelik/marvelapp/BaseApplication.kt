package com.suleymancelik.marvelapp

import com.airbnb.mvrx.Mavericks
import com.suleymancelik.marvelapp.core.di.DaggerCoreComponent
import com.suleymancelik.marvelapp.core.di.viewmodel.DaggerViewModelFactoryComponent
import com.suleymancelik.marvelapp.core.di.viewmodel.ViewModelFactoryComponent
import com.suleymancelik.marvelapp.di.AppComponent
import com.suleymancelik.marvelapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class BaseApplication : DaggerApplication() {

    private lateinit var appComponent: AppComponent
    private lateinit var viewModelFactoryComponent: ViewModelFactoryComponent

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
        configureComponents()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        configureComponents()
        return appComponent
    }

    private fun configureComponents() {
        DaggerCoreComponent.factory().create(this).let { coreComponent ->
            appComponent = DaggerAppComponent.factory().create(this, coreComponent)
            viewModelFactoryComponent =
                DaggerViewModelFactoryComponent.factory().create(appComponent.viewModelFactories())
            ViewModelFactoryComponent.storeInstance(viewModelFactoryComponent)
        }
    }
}

