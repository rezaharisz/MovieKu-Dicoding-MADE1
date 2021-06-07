package com.rezaharisz.core.di

import android.content.Context
import androidx.room.Room
import com.rezaharisz.core.data.sources.local.room.MovieKuFavoritesDao
import com.rezaharisz.core.data.sources.local.room.MovieKuRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MovieKuRoomDatabase = Room.databaseBuilder(
        context,
        MovieKuRoomDatabase::class.java, "favorites.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMovieKuFavoritesDao(database: MovieKuRoomDatabase): MovieKuFavoritesDao =
        database.movieKuFavoritesDao()

}