package com.peter.data.source

import com.peter.data.model.GithubRepoRes
import com.peter.data.service.GithubService
import javax.inject.Inject

interface GithubRemoteSource {
    suspend fun getRepos(owner : String, page : Int) : GithubRepoRes
}

class GithubRemoteSourceImpl @Inject constructor(
    private val githubService: GithubService
) : GithubRemoteSource{
    override suspend fun getRepos(owner: String, page: Int): GithubRepoRes {
        return githubService.getRepos(owner)
    }
}