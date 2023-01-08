package com.flobiz.stackoverflowing.data.vo


import com.google.gson.annotations.SerializedName

data class Styling(
    @SerializedName("link_color")
    val linkColor: String,
    @SerializedName("tag_background_color")
    val tagBackgroundColor: String,
    @SerializedName("tag_foreground_color")
    val tagForegroundColor: String
)