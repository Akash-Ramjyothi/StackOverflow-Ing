package com.flobiz.stackoverflowing.data.vo


import com.google.gson.annotations.SerializedName

data class MigratedFrom(
    @SerializedName("on_date")
    val onDate: Int,
    @SerializedName("other_site")
    val otherSite: OtherSite,
    @SerializedName("question_id")
    val questionId: Int
)