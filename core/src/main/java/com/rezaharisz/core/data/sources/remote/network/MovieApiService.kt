package com.rezaharisz.core.data.sources.remote.network

import com.rezaharisz.core.BuildConfig.API_KEY
import com.rezaharisz.core.data.sources.remote.responses.ResponseMovie
import com.rezaharisz.core.data.sources.remote.responses.ResponseTvShows
import retrofit2.http.GET

interface MovieApiService {
    @GET("movie/popular?api_key=${API_KEY}")
    suspend fun getMovie(): ResponseMovie

    @GET("tv/popular?api_key=${API_KEY}")
    suspend fun getTvShows(): ResponseTvShows
}
