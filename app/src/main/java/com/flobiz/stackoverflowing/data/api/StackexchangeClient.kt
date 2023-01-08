package com.flobiz.stackoverflowing.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_KEY = "ZiXCZbWaOwnDgpVT9Hx8IA(("
const val BASE_URL = "https://api.stackexchange.com/2.2"

// https://api.stackexchange.com/2.2/questions?key=ZiXCZbWaOwnDgpVT9Hx8IA((&order=desc&sort=activity&site=stackoverflow

object StackexchangeClient {

    fun getClient(): StackexchangeInterface{

        val requestInterceptor = Interceptor { chain ->

            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60,TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StackexchangeInterface::class.java)
    }
}