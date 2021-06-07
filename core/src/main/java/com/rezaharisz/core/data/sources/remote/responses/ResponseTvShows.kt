package com.rezaharisz.core.data.sources.remote.responses

import com.google.gson.annotations.SerializedName

data class ResponseTvShows(
        @field:SerializedName("results")
        val results: List<ResponseDataTvShows>
)