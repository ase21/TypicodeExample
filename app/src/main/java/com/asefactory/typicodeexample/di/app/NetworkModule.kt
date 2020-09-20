package com.asefactory.typicodeexample.di.app

import com.asefactory.typicodeexample.data.network.NetworkInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    private val URL = "http://jsonplaceholder.typicode.com/"
    private val TIMEOUT = 30

    @Singleton
    @Provides
    fun provideNetworkRepository(): NetworkInterface {
        return Retrofit.Builder().baseUrl(URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetworkInterface::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(createLoggingInterceptor()!!)
            .build()
    }

    private fun createLoggingInterceptor(): HttpLoggingInterceptor? {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }
}
