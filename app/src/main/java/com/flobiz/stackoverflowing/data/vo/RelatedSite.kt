package com.flobiz.stackoverflowing.data.vo


import com.google.gson.annotations.SerializedName

data class RelatedSite(
    @SerializedName("api_site_parameter")
    val apiSiteParameter: String,
    val name: String,
    val relation: String,
    @SerializedName("site_url")
    val siteUrl: String
)