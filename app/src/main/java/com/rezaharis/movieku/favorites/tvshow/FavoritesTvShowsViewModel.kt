package com.rezaharis.movieku.favorites.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaharis.movieku.core.domain.usecase.MovieKuUseCase

class FavoritesTvShowsViewModel(movieKuUseCase: MovieKuUseCase): ViewModel() {
    val favoriteTvShows = movieKuUseCase.getFavoriteTvShows().asLiveData()
}