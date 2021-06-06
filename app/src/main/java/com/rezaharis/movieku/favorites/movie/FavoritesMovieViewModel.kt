package com.rezaharis.movieku.favorites.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaharis.movieku.core.domain.usecase.MovieKuUseCase

class FavoritesMovieViewModel(movieKuUseCase: MovieKuUseCase): ViewModel() {
    val favoriteMovies = movieKuUseCase.getFavoriteMovies().asLiveData()
}