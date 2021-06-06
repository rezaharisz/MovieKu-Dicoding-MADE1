package com.rezaharis.movieku.core.domain.repository

import com.rezaharis.movieku.core.domain.model.Movies
import com.rezaharis.movieku.core.domain.model.TvShows
import com.rezaharis.movieku.core.data.Resource
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