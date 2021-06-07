package com.rezaharisz.core.di

import com.rezaharisz.core.data.MovieKuRepository
import com.rezaharisz.core.domain.repository.IMovieKuRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieKuRepository: MovieKuRepository): IMovieKuRepository

}