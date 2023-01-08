package com.flobiz.stackoverflowing.question_details

import androidx.lifecycle.LiveData
import com.flobiz.stackoverflowing.data.api.StackexchangeInterface
import com.flobiz.stackoverflowing.data.repository.NetworkState
import com.flobiz.stackoverflowing.data.repository.QuestionDetailsNetworkDataSource
import io.reactivex.disposables.CompositeDisposable

class QuestionDetailsRepository (private val apiService : StackexchangeInterface) {

    lateinit var questionDetailsNetworkDataSource: QuestionDetailsNetworkDataSource

    fun fetchQuestionDetails (compositeDisposable: CompositeDisposable) : LiveData<QuestionDetails> {

        questionDetailsNetworkDataSource = QuestionDetailsNetworkDataSource(apiService,compositeDisposable)
        questionDetailsNetworkDataSource.fetchQuestionDetails()

        return questionDetailsNetworkDataSource.downloadedQuestionDetailsResponse

    }

    fun getQuestionDetailsNetworkState(): LiveData<NetworkState> {
        return questionDetailsNetworkDataSource.networkState
    }

}