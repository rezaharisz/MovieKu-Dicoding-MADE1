package com.rezaharis.movieku.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaharisz.core.domain.usecase.MovieKuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvShowsViewModel @Inject constructor(movieKuUseCase: MovieKuUseCase): ViewModel() {
    val tvShows = movieKuUseCase.getTvShows().asLiveData()
}