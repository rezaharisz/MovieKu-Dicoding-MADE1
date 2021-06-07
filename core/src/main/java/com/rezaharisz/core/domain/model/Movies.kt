package com.rezaharisz.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies (

    val id: Int? = null,

    val poster: String? = null,

    val movieName: String? = null,

    val description: String? = null,

    val releasedate: String? = null,

    val rate: Double? = null,

    val votecount: Int? = null,

    val setFavorite: Boolean = false

): Parcelable