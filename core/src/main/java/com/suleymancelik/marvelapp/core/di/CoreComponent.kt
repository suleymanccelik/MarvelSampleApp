package com.suleymancelik.marvelapp.core.di

import android.content.Context
import android.content.SharedPreferences
import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import com.suleymancelik.marvelapp.core.di.module.NetworkModule
import com.suleymancelik.marvelapp.core.di.module.SharedPreferencesModule

@Component(
    modules = [
        NetworkModule::class,
        SharedPreferencesModule::class
    ]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): CoreComponent
    }

    fun provideOkHttpClient(): OkHttpClient

    fun provideRetrofit(): Retrofit

    fun provideSharedPreferencesEditor(): SharedPreferences.Editor

    fun provideSharedPreference(): SharedPreferences
}