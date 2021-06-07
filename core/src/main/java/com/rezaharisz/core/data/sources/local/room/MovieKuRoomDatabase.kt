package com.rezaharisz.core.data.sources.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rezaharisz.core.data.sources.local.entity.MovieEntities
import com.rezaharisz.core.data.sources.local.entity.TvShowsEntities

@Database(entities = [MovieEntities::class, TvShowsEntities::class], version = 1, exportSchema = false)
abstract class MovieKuRoomDatabase: RoomDatabase() {
    abstract fun movieKuFavoritesDao(): MovieKuFavoritesDao
}