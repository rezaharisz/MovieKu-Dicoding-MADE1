package com.rezaharis.movieku.core.data.sources.remote.network

import com.rezaharis.movieku.BuildConfig
import com.rezaharis.movieku.core.data.sources.remote.responses.ResponseMovie
import com.rezaharis.movieku.core.data.sources.remote.responses.ResponseTvShows
import retrofit2.http.GET

interface MovieApiService {
    @GET("movie/popular?api_key=${BuildConfig.API_KEY}")
    suspend fun getMovie(): ResponseMovie

    @GET("tv/popular?api_key=${BuildConfig.API_KEY}")
    suspend fun getTvShows(): ResponseTvShows
}
