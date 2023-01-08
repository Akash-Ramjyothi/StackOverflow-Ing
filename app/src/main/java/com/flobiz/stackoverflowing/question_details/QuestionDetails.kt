package com.flobiz.stackoverflowing.question_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.flobiz.stackoverflowing.R
import com.flobiz.stackoverflowing.data.api.StackexchangeClient
import com.flobiz.stackoverflowing.data.api.StackexchangeInterface
import java.text.NumberFormat
import java.util.*

class QuestionDetails : AppCompatActivity() {

    private lateinit var viewModel: QuestionDetailsViewModel
    private lateinit var questionRepository: QuestionDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_details)

        val apiService : StackexchangeInterface = StackexchangeClient.getClient()
        questionRepository = QuestionDetailsRepository(apiService)

        //viewModel = getViewModel()

        viewModel.questionDetails.observe(this, Observer {
            //bindUI(it)
        })
    }

//    fun bindUI( it: QuestionDetails){
////        movie_title.text = it.title
////        movie_tagline.text = it.tagline
////        movie_release_date.text = it.releaseDate
////        movie_rating.text = it.rating.toString()
////        movie_runtime.text = it.runtime.toString() + " minutes"
////        movie_overview.text = it.overview
//
//
//        val formatCurrency = NumberFormat.getCurrencyInstance(Locale.US)
//        movie_budget.text = formatCurrency.format(it.budget)
//        movie_revenue.text = formatCurrency.format(it.revenue)
//
//        val moviePosterURL = POSTER_BASE_URL + it.posterPath
//        Glide.with(this)
//            .load(moviePosterURL)
//            .into(iv_movie_poster);
//
//
//    }

//    private fun getViewModel(): QuestionDetailsViewModel {
//        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                @Suppress("UNCHECKED_CAST")
//                return QuestionDetailsViewModel(questionRepository) as T
//            }
//        })[QuestionDetailsViewModel::class.java]
//    }

}