package com.rezaharis.movieku.di

import com.rezaharisz.core.domain.usecase.MovieKuInteractor
import com.rezaharisz.core.domain.usecase.MovieKuUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideMovieKuUseCase(movieKuInteractor: MovieKuInteractor): MovieKuUseCase

}