package com.suleymancelik.marvelapp.core

class Constant {

    val marvelRestURL = "https://gateway.marvel.com/v1/public/"

    companion object {
        const val BASE_URL = "https://gateway.marvel.com/v1/public/"
        const val HASH = BuildConfig.MARVEL_HASH
        const val PUBLIC_KEY = BuildConfig.MARVEL_PUBLIC_KEY
    }

}