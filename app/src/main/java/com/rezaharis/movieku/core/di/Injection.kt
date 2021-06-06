package com.rezaharis.movieku.core.di

import android.content.Context
import com.rezaharis.movieku.core.data.sources.remote.sources.RemoteDataSource
import com.rezaharis.movieku.core.data.MovieKuRepository
import com.rezaharis.movieku.core.data.sources.local.room.MovieKuRoomDatabase
import com.rezaharis.movieku.core.data.sources.local.sources.LocalDataSources
import com.rezaharis.movieku.core.domain.repository.IMovieKuRepository
import com.rezaharis.movieku.core.domain.usecase.MovieKuInteractor
import com.rezaharis.movieku.core.domain.usecase.MovieKuUseCase
import com.rezaharis.movieku.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): IMovieKuRepository {

        val database = MovieKuRoomDatabase.getInstance(context)
        val movieKuDataSource = RemoteDataSource()
        val localDataSources = LocalDataSources.getInstance(database.movieKuFavoritesDao())
        val appExecutors = AppExecutors()

        return MovieKuRepository.getInstance(movieKuDataSource, localDataSources, appExecutors)
    }

    fun provideMovieKuUseCase(context: Context): MovieKuUseCase{
        val repository = provideRepository(context)
        return MovieKuInteractor(repository)
    }
}