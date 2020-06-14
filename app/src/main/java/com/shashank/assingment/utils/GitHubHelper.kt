package com.shashank.assingment.utils

import com.shashank.assingment.responseModel.PullRequestDatum
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubHelper {
    @GET("/repos/{owner}/{repo}/pulls")
    suspend fun getClosedPullRepo(@Path("owner") owner : String, @Path("repo") repoName : String, @Query("state") state :String ) :Response<List<PullRequestDatum>>
}