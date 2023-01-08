package com.flobiz.stackoverflowing.data.vo


import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("accept_rate")
    val acceptRate: Int,
    @SerializedName("display_name")
    val displayName: String,
    val link: String,
    @SerializedName("profile_image")
    val profileImage: String,
    val reputation: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_type")
    val userType: String
)