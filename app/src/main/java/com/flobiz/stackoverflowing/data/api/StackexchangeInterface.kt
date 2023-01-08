package com.flobiz.stackoverflowing.data.api

import com.flobiz.stackoverflowing.question_details.QuestionDetails
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//interface StackexchangeInterface {
//    // https://api.stackexchange.com/2.2/questions?key=ZiXCZbWaOwnDgpVT9Hx8IA((&order=desc&sort=activity&site=stackoverflow
//
//    @GET("/popular")
//    fun getQuestionList(@Query)
//
//    @GET("/")
//    fun getQuestionDetails(): Single<QuestionDetails>
//}

interface StackexchangeInterface {
    @GET("questions")
    fun getQuestionDetails(@Query("key") key: String,
                     @Query("order") order: String,
                     @Query("sort") sort: String,
                     @Query("site") site: String): Call<List<Question>>
}

data class Question(val tags: List<String>,
                    val owner: Owner,
                    val isAnswered: Boolean,
                    val viewCount: Int,
                    val answerCount: Int,
                    val score: Int,
                    val lastActivityDate: Long,
                    val creationDate: Long,
                    val questionId: Long,
                    val contentLicense: String,
                    val link: String,
                    val title: String)

data class Owner(val reputation: Int,
                 val userId: Long,
                 val userType: String,
                 val profileImage: String,
                 val displayName: String,
                 val link: String)
