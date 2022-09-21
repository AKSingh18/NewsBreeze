package com.greedygame.aksingh.newsbreeze.model

import com.google.gson.annotations.SerializedName

data class HeadlineResponse(
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("totalResults")
    val totalResults: Int? = 0,
    @SerializedName("articles")
    val headlines: List<Headline>? = null
)