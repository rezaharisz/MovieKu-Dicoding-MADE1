package com.rezaharisz.core.domain.usecase

import com.rezaharisz.core.domain.model.Movies
import com.rezaharisz.core.domain.model.TvShows
import com.rezaharisz.core.domain.repository.IMovieKuRepository
import javax.inject.Inject

class MovieKuInteractor @Inject constructor(private val movieKuRepository: IMovieKuRepository): MovieKuUseCase {
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