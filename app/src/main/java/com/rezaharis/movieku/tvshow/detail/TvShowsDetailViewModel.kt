package com.rezaharis.movieku.tvshow.detail

import androidx.lifecycle.ViewModel
import com.rezaharis.movieku.core.domain.model.TvShows
import com.rezaharis.movieku.core.domain.usecase.MovieKuUseCase

class TvShowsDetailViewModel(private val movieKuUseCase: MovieKuUseCase): ViewModel() {

    fun setFavoriteTvShows(tvShows: TvShows, state: Boolean) = movieKuUseCase.setFavoriteTvShows(tvShows, state)
}