package com.rezaharis.movieku.movie.detail

import androidx.lifecycle.ViewModel
import com.rezaharisz.core.domain.model.Movies
import com.rezaharisz.core.domain.usecase.MovieKuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val movieKuUseCase: MovieKuUseCase): ViewModel() {

    fun setFavoriteMovies(movies: Movies, state: Boolean) = movieKuUseCase.setFavoriteMovies(movies, state)

}