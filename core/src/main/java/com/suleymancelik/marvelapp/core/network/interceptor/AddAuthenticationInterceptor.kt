package com.suleymancelik.marvelapp.core.network.interceptor

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AddAuthenticationInterceptor @Inject constructor(
    private val hashValue: String,
    private val apiKeyValue: String,
    private val timestampValue: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        val url: HttpUrl = request.url.newBuilder()
            .addQueryParameter("apikey", apiKeyValue)
            .addQueryParameter("ts", timestampValue)
            .addQueryParameter("hash", hashValue).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}