package com.shashank.assingment.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shashank.assingment.responseModel.PullRequestDatum
import com.shashank.assingment.utils.ApiClient
import com.shashank.assingment.utils.GitHubHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class HomeViewModel : ViewModel() {
    private val pullList by lazy { MutableLiveData<List<PullRequestDatum>>() }

    fun getPullList():LiveData<List<PullRequestDatum>> = pullList

    @Throws(IOException::class)
    fun fetchPullRequests(owner : String , repo : String ,  state : String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                Log.v("check1", "I am here")
                val response = ApiClient.retrofit.create(GitHubHelper::class.java).getClosedPullRepo(owner,repo,state)
                if (response.isSuccessful){
                    Log.v("check2", "I am here")
                    pullList.postValue(response.body())
                }else {
                    Log.v("check3" , "I am here")
                }
            }
        }
    }
}