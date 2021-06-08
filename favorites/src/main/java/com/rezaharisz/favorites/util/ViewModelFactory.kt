@file:Suppress("UNCHECKED_CAST")

package com.rezaharisz.favorites.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rezaharisz.core.domain.usecase.MovieKuUseCase
import com.rezaharisz.favorites.movies.FavoritesMovieViewModel
import com.rezaharisz.favorites.tvshows.FavoritesTvShowsViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val movieKuUseCase: MovieKuUseCase): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when{
            modelClass.isAssignableFrom(FavoritesMovieViewModel::class.java) -> {
                FavoritesMovieViewModel(movieKuUseCase) as T
            }
            modelClass.isAssignableFrom(FavoritesTvShowsViewModel::class.java) -> {
                FavoritesTvShowsViewModel(movieKuUseCase) as T
            }
            else -> throw Throwable("Unkwon ViewModel Class: ${modelClass.name}")
        }
}