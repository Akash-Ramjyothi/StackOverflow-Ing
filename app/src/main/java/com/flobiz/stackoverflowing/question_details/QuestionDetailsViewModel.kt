package com.flobiz.stackoverflowing.question_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.flobiz.stackoverflowing.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class QuestionDetailsViewModel (private val questionRepository : QuestionDetailsRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val questionDetails : LiveData<QuestionDetails> by lazy {
        questionRepository.fetchQuestionDetails(compositeDisposable)
    }

    val networkState : LiveData<NetworkState> by lazy {
        questionRepository.getQuestionDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}