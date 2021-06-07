package com.rezaharis.movieku.tvshow.detail

import androidx.lifecycle.ViewModel
import com.rezaharisz.core.domain.model.TvShows
import com.rezaharisz.core.domain.usecase.MovieKuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvShowsDetailViewModel @Inject constructor(private val movieKuUseCase: MovieKuUseCase): ViewModel() {

    fun setFavoriteTvShows(tvShows: TvShows, state: Boolean) = movieKuUseCase.setFavoriteTvShows(tvShows, state)
}