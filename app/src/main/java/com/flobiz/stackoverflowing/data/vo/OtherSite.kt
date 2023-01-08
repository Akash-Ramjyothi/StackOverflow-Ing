package com.flobiz.stackoverflowing.data.vo


import com.google.gson.annotations.SerializedName

data class OtherSite(
    @SerializedName("api_site_parameter")
    val apiSiteParameter: String,
    val audience: String,
    @SerializedName("closed_beta_date")
    val closedBetaDate: Int,
    @SerializedName("favicon_url")
    val faviconUrl: String,
    @SerializedName("high_resolution_icon_url")
    val highResolutionIconUrl: String,
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("launch_date")
    val launchDate: Int,
    @SerializedName("logo_url")
    val logoUrl: String,
    @SerializedName("markdown_extensions")
    val markdownExtensions: List<String>,
    val name: String,
    @SerializedName("open_beta_date")
    val openBetaDate: Int,
    @SerializedName("related_sites")
    val relatedSites: List<RelatedSite>,
    @SerializedName("site_state")
    val siteState: String,
    @SerializedName("site_type")
    val siteType: String,
    @SerializedName("site_url")
    val siteUrl: String,
    val styling: Styling,
    @SerializedName("twitter_account")
    val twitterAccount: String
)