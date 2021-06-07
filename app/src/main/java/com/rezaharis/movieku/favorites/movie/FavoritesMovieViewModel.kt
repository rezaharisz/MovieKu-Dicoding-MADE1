package com.rezaharis.movieku.favorites.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaharisz.core.domain.usecase.MovieKuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesMovieViewModel @Inject constructor(movieKuUseCase: MovieKuUseCase): ViewModel() {
    val favoriteMovies = movieKuUseCase.getFavoriteMovies().asLiveData()
}