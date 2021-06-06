package com.rezaharis.movieku.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaharis.movieku.core.domain.usecase.MovieKuUseCase

class MovieViewModel(movieKuUseCase: MovieKuUseCase): ViewModel() {
    val movies = movieKuUseCase.getMovies().asLiveData()
}