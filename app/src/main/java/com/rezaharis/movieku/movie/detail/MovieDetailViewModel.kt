package com.rezaharis.movieku.movie.detail

import androidx.lifecycle.ViewModel
import com.rezaharis.movieku.core.domain.model.Movies
import com.rezaharis.movieku.core.domain.usecase.MovieKuUseCase

class MovieDetailViewModel(private val movieKuUseCase: MovieKuUseCase): ViewModel() {

    fun setFavoriteMovies(movies: Movies, state: Boolean) = movieKuUseCase.setFavoriteMovies(movies, state)

}