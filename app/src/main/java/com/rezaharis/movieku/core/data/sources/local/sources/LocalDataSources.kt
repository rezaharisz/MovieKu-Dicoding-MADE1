package com.rezaharis.movieku.core.data.sources.local.sources

import com.rezaharis.movieku.core.data.sources.local.entity.MovieEntities
import com.rezaharis.movieku.core.data.sources.local.entity.TvShowsEntities
import com.rezaharis.movieku.core.data.sources.local.room.MovieKuFavoritesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSources(private val movieKuFavoritesDao: MovieKuFavoritesDao){
    companion object{
        private var INSTANCE: LocalDataSources? = null

        fun getInstance(movieKuFavoritesDao: MovieKuFavoritesDao): LocalDataSources =
            INSTANCE ?: LocalDataSources(movieKuFavoritesDao)
    }

    //Movies
    fun getAllMovies(): Flow<List<MovieEntities>> = movieKuFavoritesDao.getMovies()

    fun getFavoriteMovies(): Flow<List<MovieEntities>> = movieKuFavoritesDao.getFavoriteMovies()

    suspend fun insertMovies(movieEntities: List<MovieEntities>) = movieKuFavoritesDao.insertMovies(movieEntities)

    fun setFavoriteMovies(movieEntities: MovieEntities, newState: Boolean){
        movieEntities.setFavorite = newState
        movieKuFavoritesDao.updateMovies(movieEntities)
    }

    //TvShows
    fun getAlltTvShows(): Flow<List<TvShowsEntities>> = movieKuFavoritesDao.getTvShows()

    fun getFavoriteTvShows(): Flow<List<TvShowsEntities>> = movieKuFavoritesDao.getFavoriteTvShows()

    suspend fun insertTvShows(tvShowsEntities: List<TvShowsEntities>) = movieKuFavoritesDao.insertTvShows(tvShowsEntities)

    fun setFavoriteTvShows(tvShowsEntities: TvShowsEntities, newState: Boolean){
        tvShowsEntities.setFavorite = newState
        movieKuFavoritesDao.updateTvShows(tvShowsEntities)
    }
}