package com.suleymancelik.marvelapp.di

import android.content.Context
import com.suleymancelik.marvelapp.BaseApplication
import com.suleymancelik.marvelapp.list.di.CharacterListModule
import dagger.Module
import dagger.Provides


@Module(
    includes = [CharacterListModule::class]
)
class AppModule {

    @Provides
    fun provideContext(application: BaseApplication): Context = application.applicationContext

}