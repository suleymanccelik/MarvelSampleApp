package com.suleymancelik.marvelapp.core.di.module

import com.suleymancelik.marvelapp.core.AppConfig
import com.suleymancelik.marvelapp.core.BuildConfig
import com.suleymancelik.marvelapp.core.network.interceptor.AddAuthenticationInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }

    @Provides
    fun provideClient(
        interceptor: HttpLoggingInterceptor,
        @Named("hash") hashValue: String,
        @Named("apiKey") apiKeyValue: String,
        @Named("timestamp") timestampValue: String,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(interceptor)
            .addInterceptor(AddAuthenticationInterceptor(hashValue, apiKeyValue, timestampValue))
            .build()
    }

    @Provides
    @Named("baseUrl")
    fun provideBaseURL(): String = AppConfig().getRestBaseURL()

    @Provides
    @Named("hash")
    fun provideHashValue(): String = AppConfig().getHash()

    @Provides
    @Named("apiKey")
    fun provideApiKey(): String = AppConfig().getPublicKey()

    @Provides
    @Named("timestamp")
    fun provideTimestamp(): String = "1"

    @Provides
    fun provideLoginRetrofit(@Named("baseUrl") baseURL: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}