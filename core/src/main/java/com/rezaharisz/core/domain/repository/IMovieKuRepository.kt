package com.rezaharisz.core.domain.repository

import com.rezaharisz.core.data.Resource
import com.rezaharisz.core.domain.model.Movies
import com.rezaharisz.core.domain.model.TvShows
import kotlinx.coroutines.flow.Flow

interface IMovieKuRepository {
    //MOVIES
    fun getMovies(): Flow<Resource<List<Movies>>>
    fun getFavoriteMovies(): Flow<List<Movies>>
    fun setFavoriteMovies(movies: Movies, state: Boolean)

    //TV SHOWS
    fun getTvShows(): Flow<Resource<List<TvShows>>>
    fun getFavoriteTvShows(): Flow<List<TvShows>>
    fun setFavoriteTvShows(tvShows: TvShows, state: Boolean)
}