package com.suleymancelik.marvelapp.core

class AppConfig {

    private val debugMode = 100
    private val liveMode = 102

    private val runningMode: Int = debugMode

    fun getRestBaseURL(): String {
        return when (runningMode) {
            debugMode -> Constant.BASE_URL
            liveMode -> Constant.BASE_URL
            else -> throw UnsupportedOperationException("Choose one: RUN_DEBUG or LIVE?")
        }
    }

    fun getHash(): String {
        return when (runningMode) {
            debugMode -> Constant.HASH
            liveMode -> Constant.HASH
            else -> throw UnsupportedOperationException("Choose one: RUN_DEBUG or LIVE?")
        }
    }

    fun getPublicKey(): String {
        return when (runningMode) {
            debugMode -> Constant.PUBLIC_KEY
            liveMode -> Constant.PUBLIC_KEY
            else -> throw UnsupportedOperationException("Choose one: RUN_DEBUG or LIVE?")
        }
    }
}