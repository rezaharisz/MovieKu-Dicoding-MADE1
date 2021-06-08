package com.rezaharisz.favorites.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaharisz.core.domain.usecase.MovieKuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesTvShowsViewModel @Inject constructor(movieKuUseCase: MovieKuUseCase): ViewModel() {
    val favoriteTvShows = movieKuUseCase.getFavoriteTvShows().asLiveData()
}