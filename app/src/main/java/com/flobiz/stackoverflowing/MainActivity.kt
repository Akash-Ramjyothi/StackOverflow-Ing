package com.flobiz.stackoverflowing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.flobiz.stackoverflowing.data.api.StackexchangeClient
import com.flobiz.stackoverflowing.data.api.StackexchangeInterface
import com.flobiz.stackoverflowing.question_details.QuestionAdapter
import com.flobiz.stackoverflowing.question_details.QuestionDetailsRepository
import com.flobiz.stackoverflowing.question_details.QuestionDetailsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuestionDetailsViewModel

    lateinit var questionRepository: QuestionDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService : StackexchangeInterface = StackexchangeClient.getClient()

        questionRepository = QuestionDetailsRepository(apiService)

        viewModel = getViewModel()

        val questionAdapter = QuestionAdapter(this)

        val gridLayoutManager = GridLayoutManager(this, 3)

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val viewType = questionAdapter.getItemViewType(position)
                if (viewType == questionAdapter.MOVIE_VIEW_TYPE) return  1    // Movie_VIEW_TYPE will occupy 1 out of 3 span
                else return 3                                              // NETWORK_VIEW_TYPE will occupy all 3 span
            }
        };
    }

    private fun getViewModel(): QuestionDetailsViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return QuestionDetailsViewModel(questionRepository) as T
            }
        })[QuestionDetailsViewModel::class.java]
    }

}