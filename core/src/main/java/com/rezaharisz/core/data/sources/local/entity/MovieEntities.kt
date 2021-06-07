package com.rezaharisz.core.data.sources.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_entities")
data class MovieEntities(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "movie_id")
    var id: Int? = null,

    @ColumnInfo(name = "movie_poster")
    var poster: String? = null,

    @ColumnInfo(name = "movie_movieName")
    var movieName: String? = null,

    @ColumnInfo(name = "movie_description")
    var description: String? = null,

    @ColumnInfo(name = "movie_releasedate")
    var releasedate: String? = null,

    @ColumnInfo(name = "movie_rate")
    var rate: Double? = null,

    @ColumnInfo(name = "movie_votecount")
    var votecount: Int? = null,

    @ColumnInfo(name = "movie_setfavorite")
    var setFavorite: Boolean = false
)