package com.suleymancelik.marvelapp.core.di.viewmodel

import dagger.MapKey
import com.suleymancelik.marvelapp.core.di.MvRxViewModel
import kotlin.reflect.KClass

/**
 * A [MapKey] for populating a map of ViewModels and their factories
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class ViewModelKey(val value: KClass<out MvRxViewModel<*>>)