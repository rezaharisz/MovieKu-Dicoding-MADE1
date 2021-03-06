package com.rezaharis.movieku.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaharisz.core.domain.usecase.MovieKuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(movieKuUseCase: MovieKuUseCase): ViewModel() {
    val movies = movieKuUseCase.getMovies().asLiveData()
}