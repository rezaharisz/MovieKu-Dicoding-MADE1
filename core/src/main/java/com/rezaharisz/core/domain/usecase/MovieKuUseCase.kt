package com.rezaharisz.core.domain.usecase

import com.rezaharisz.core.data.Resource
import com.rezaharisz.core.domain.model.Movies
import com.rezaharisz.core.domain.model.TvShows
import kotlinx.coroutines.flow.Flow

interface MovieKuUseCase {

    //MOVIES
    fun getMovies(): Flow<Resource<List<Movies>>>
    fun getFavoriteMovies(): Flow<List<Movies>>
    fun setFavoriteMovies(movies: Movies, state: Boolean)

    //TVSHOWS
    fun getTvShows(): Flow<Resource<List<TvShows>>>
    fun getFavoriteTvShows(): Flow<List<TvShows>>
    fun setFavoriteTvShows(tvShows: TvShows, state: Boolean)

}