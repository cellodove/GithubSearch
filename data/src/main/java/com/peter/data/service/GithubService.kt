package com.peter.data.service

import com.peter.data.model.GithubRepoRes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/users")
    suspend fun getRepos(@Query("q") q : String,/*@Query("page") page : Int = 1*/) : GithubRepoRes
}