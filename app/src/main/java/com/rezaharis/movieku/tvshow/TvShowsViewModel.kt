package com.rezaharis.movieku.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaharis.movieku.core.domain.usecase.MovieKuUseCase

class TvShowsViewModel(movieKuUseCase: MovieKuUseCase): ViewModel() {
    val tvShows = movieKuUseCase.getTvShows().asLiveData()
}