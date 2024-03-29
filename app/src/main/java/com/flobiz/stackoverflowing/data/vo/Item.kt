package com.flobiz.stackoverflowing.data.vo


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("accepted_answer_id")
    val acceptedAnswerId: Int,
    @SerializedName("answer_count")
    val answerCount: Int,
    @SerializedName("bounty_amount")
    val bountyAmount: Int,
    @SerializedName("bounty_closes_date")
    val bountyClosesDate: Int,
    @SerializedName("closed_date")
    val closedDate: Int,
    @SerializedName("closed_reason")
    val closedReason: String,
    @SerializedName("content_license")
    val contentLicense: String,
    @SerializedName("creation_date")
    val creationDate: Int,
    @SerializedName("is_answered")
    val isAnswered: Boolean,
    @SerializedName("last_activity_date")
    val lastActivityDate: Int,
    @SerializedName("last_edit_date")
    val lastEditDate: Int,
    val link: String,
    @SerializedName("migrated_from")
    val migratedFrom: MigratedFrom,
    val owner: Owner,
    @SerializedName("question_id")
    val questionId: Int,
    val score: Int,
    val tags: List<String>,
    val title: String,
    @SerializedName("view_count")
    val viewCount: Int
)