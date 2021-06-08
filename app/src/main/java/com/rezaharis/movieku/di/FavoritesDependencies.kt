package com.rezaharis.movieku.di

import com.rezaharisz.core.domain.usecase.MovieKuUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoritesDependencies {
    fun movieKuUseCase(): MovieKuUseCase
}