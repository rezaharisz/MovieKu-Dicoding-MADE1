package com.rezaharis.movieku.core.data.sources.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rezaharis.movieku.core.data.sources.local.entity.MovieEntities
import com.rezaharis.movieku.core.data.sources.local.entity.TvShowsEntities

@Database(entities = [MovieEntities::class, TvShowsEntities::class], version = 1, exportSchema = false)
abstract class MovieKuRoomDatabase: RoomDatabase() {
    abstract fun movieKuFavoritesDao(): MovieKuFavoritesDao

    companion object{
        @Volatile
        private var INSTANCE: MovieKuRoomDatabase? = null

        fun getInstance(context: Context): MovieKuRoomDatabase =
            INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    MovieKuRoomDatabase::class.java,
                    "favorites.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}