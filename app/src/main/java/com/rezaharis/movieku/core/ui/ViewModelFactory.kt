package com.rezaharis.movieku.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rezaharis.movieku.core.di.Injection
import com.rezaharis.movieku.core.domain.usecase.MovieKuUseCase
import com.rezaharis.movieku.favorites.movie.FavoritesMovieViewModel
import com.rezaharis.movieku.favorites.tvshow.FavoritesTvShowsViewModel
import com.rezaharis.movieku.movie.detail.MovieDetailViewModel
import com.rezaharis.movieku.movie.MovieViewModel
import com.rezaharis.movieku.tvshow.detail.TvShowsDetailViewModel
import com.rezaharis.movieku.tvshow.TvShowsViewModel

class ViewModelFactory private constructor(private val movieKuUseCase: MovieKuUseCase): ViewModelProvider.NewInstanceFactory() {

    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this){
                    instance ?: ViewModelFactory(Injection.provideMovieKuUseCase(context))
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(movieKuUseCase) as T
            }

            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> {
                TvShowsViewModel(movieKuUseCase) as T
            }

            modelClass.isAssignableFrom(MovieDetailViewModel::class.java) -> {
                MovieDetailViewModel(movieKuUseCase) as T
            }

            modelClass.isAssignableFrom(TvShowsDetailViewModel::class.java) -> {
                TvShowsDetailViewModel(movieKuUseCase) as T
            }

            modelClass.isAssignableFrom(FavoritesMovieViewModel::class.java) -> {
                FavoritesMovieViewModel(movieKuUseCase) as T
            }

            modelClass.isAssignableFrom(FavoritesTvShowsViewModel::class.java) -> {
                FavoritesTvShowsViewModel(movieKuUseCase) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}