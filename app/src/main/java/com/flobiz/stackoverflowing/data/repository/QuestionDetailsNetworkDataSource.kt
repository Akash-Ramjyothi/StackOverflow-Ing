package com.flobiz.stackoverflowing.data.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.flobiz.stackoverflowing.data.api.StackexchangeInterface
import com.flobiz.stackoverflowing.question_details.QuestionDetails
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call

class QuestionDetailsNetworkDataSource (private val apiService: StackexchangeInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState                   //with this get, no need to implement get function to get networkSate

    private val _downloadedQuestionDetailsResponse =  MutableLiveData<QuestionDetails>()
    val downloadedQuestionDetailsResponse: LiveData<QuestionDetails>
        get() = _downloadedQuestionDetailsResponse

    @SuppressLint("LongLogTag")
    fun fetchQuestionDetails() {

        _networkState.postValue(NetworkState.LOADING)


        try {
            compositeDisposable.add(
                apiService.getQuestionDetails()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedQuestionDetailsResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("QuestionDetailsDataSource", it.message.toString())
                        }
                    )
            )

        }

        catch (e: Exception){
            Log.e("QuestionDetailsDataSource", e.message.toString())
        }


    }

}

private fun Any.subscribe(function: () -> Unit, function1: () -> Int): Disposable {

}

private fun <T> Call<T>.subscribeOn(io: Scheduler): Any {

}
