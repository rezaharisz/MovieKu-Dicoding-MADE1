package com.rezaharis.movieku.di

import com.rezaharisz.core.data.MovieKuRepository
import com.rezaharisz.core.domain.usecase.MovieKuInteractor
import com.rezaharisz.core.domain.usecase.MovieKuUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieKuUseCase(movieKuRepository: MovieKuRepository): MovieKuUseCase =
        MovieKuInteractor(movieKuRepository)

}