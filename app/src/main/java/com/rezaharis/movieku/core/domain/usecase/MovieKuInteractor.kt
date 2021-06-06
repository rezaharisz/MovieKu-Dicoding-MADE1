package com.rezaharis.movieku.core.domain.usecase

import com.rezaharis.movieku.core.domain.model.Movies
import com.rezaharis.movieku.core.domain.model.TvShows
import com.rezaharis.movieku.core.domain.repository.IMovieKuRepository

class MovieKuInteractor(private val movieKuRepository: IMovieKuRepository): MovieKuUseCase {
    override fun getMovies() = movieKuRepository.getMovies()

    override fun getFavoriteMovies() = movieKuRepository.getFavoriteMovies()

    override fun setFavoriteMovies(movies: Movies, state: Boolean) {
        return movieKuRepository.setFavoriteMovies(movies, state)
    }

    override fun getTvShows() = movieKuRepository.getTvShows()

    override fun getFavoriteTvShows() = movieKuRepository.getFavoriteTvShows()

    override fun setFavoriteTvShows(tvShows: TvShows, state: Boolean) {
        return movieKuRepository.setFavoriteTvShows(tvShows, state)
    }

}