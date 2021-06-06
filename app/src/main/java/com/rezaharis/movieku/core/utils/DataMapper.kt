package com.rezaharis.movieku.core.utils

import com.rezaharis.movieku.core.domain.model.Movies
import com.rezaharis.movieku.core.domain.model.TvShows
import com.rezaharis.movieku.core.data.sources.local.entity.MovieEntities
import com.rezaharis.movieku.core.data.sources.local.entity.TvShowsEntities
import com.rezaharis.movieku.core.data.sources.remote.responses.ResponseDataMovie
import com.rezaharis.movieku.core.data.sources.remote.responses.ResponseDataTvShows

object DataMapper {

    //MOVIES
    fun mapMovieResponsesToEntities(input: List<ResponseDataMovie>): List<MovieEntities>{
        val movieList = ArrayList<MovieEntities>()
        input.map {
            val movies = MovieEntities(
                id = it.id,
                poster = it.poster,
                movieName = it.movieName,
                description = it.description,
                releasedate = it.releasedate,
                rate = it.rate,
                votecount = it.votecount
            )
            movieList.add(movies)
        }
        return movieList
    }

    fun mapMovieEntitiesToDomain(input: List<MovieEntities>): List<Movies> =
        input.map {
            Movies(
                id = it.id,
                poster = it.poster,
                movieName = it.movieName,
                description = it.description,
                releasedate = it.releasedate,
                rate = it.rate,
                votecount = it.votecount,
                setFavorite = it.setFavorite
            )
        }

    fun mapMovieDomainToEntities(input: Movies) = MovieEntities(
        id = input.id,
        poster = input.poster,
        movieName = input.movieName,
        description = input.description,
        releasedate = input.releasedate,
        rate = input.rate,
        votecount = input.votecount,
        setFavorite = input.setFavorite
    )

    //TV SHOWS
    fun mapTvShowsResponsesToEntites(input: List<ResponseDataTvShows>): List<TvShowsEntities>{
        val tvShowsList = ArrayList<TvShowsEntities>()
        input.map {
            val tvShows = TvShowsEntities(
                id = it.id,
                poster = it.poster,
                tvShowsName = it.tvShowsName,
                description = it.description,
                releasedate = it.releasedate,
                rate = it.rate,
                votecount = it.votecount
            )
            tvShowsList.add(tvShows)
        }
        return tvShowsList
    }

    fun mapTvShowsEntitiesToDomain(input: List<TvShowsEntities>): List<TvShows> =
        input.map {
            TvShows(
                id = it.id,
                poster = it.poster,
                tvShowsName = it.tvShowsName,
                description = it.description,
                releasedate = it.releasedate,
                rate = it.rate,
                votecount = it.votecount,
                setFavorite = it.setFavorite
            )
        }

    fun mapTvShowsDomainToEntities(input: TvShows) = TvShowsEntities(
        id = input.id,
        poster = input.poster,
        tvShowsName = input.tvShowsName,
        description = input.description,
        releasedate = input.releasedate,
        rate = input.rate,
        votecount = input.votecount,
        setFavorite = input.setFavorite
    )

}