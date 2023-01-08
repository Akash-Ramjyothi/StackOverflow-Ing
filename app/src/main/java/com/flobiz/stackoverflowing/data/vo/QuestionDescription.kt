package com.flobiz.stackoverflowing.data.vo


import com.google.gson.annotations.SerializedName

data class QuestionDescription(
    @SerializedName("has_more")
    val hasMore: Boolean,
    val items: List<Item>,
    @SerializedName("quota_max")
    val quotaMax: Int,
    @SerializedName("quota_remaining")
    val quotaRemaining: Int
)