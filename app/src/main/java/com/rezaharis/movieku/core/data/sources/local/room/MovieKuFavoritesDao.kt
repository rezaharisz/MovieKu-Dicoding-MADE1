package com.rezaharis.movieku.core.data.sources.local.room

import androidx.room.*
import com.rezaharis.movieku.core.data.sources.local.entity.MovieEntities
import com.rezaharis.movieku.core.data.sources.local.entity.TvShowsEntities
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieKuFavoritesDao {

    //Movies
    @Query("SELECT * FROM movies_entities")
    fun getMovies(): Flow<List<MovieEntities>>

    @Query("SELECT * FROM movies_entities WHERE movie_setfavorite = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntities>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movieEntities: List<MovieEntities>)

    @Update
    fun updateMovies(movieEntities: MovieEntities)

    //TvShows
    @Query("SELECT * FROM tvshows_entities")
    fun getTvShows(): Flow<List<TvShowsEntities>>

    @Query("SELECT * FROM tvshows_entities WHERE tvshows_setfavorite = 1")
    fun getFavoriteTvShows(): Flow<List<TvShowsEntities>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShows(tvShowsEntities: List<TvShowsEntities>)

    @Update
    fun updateTvShows(tvShowsEntities: TvShowsEntities)
}