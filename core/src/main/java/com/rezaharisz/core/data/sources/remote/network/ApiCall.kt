package com.rezaharisz.core.data.sources.remote.network

import com.rezaharisz.core.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCall {
    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    val movieApiService: MovieApiService by lazy {
        Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(BASE_URL)
            client(client)
        }.build().create(MovieApiService::class.java)
    }
}