package com.rezaharis.movieku.core.data.sources.remote.responses

import com.google.gson.annotations.SerializedName

data class ResponseMovie(
        @field:SerializedName("results")
        val results: List<ResponseDataMovie>
)
