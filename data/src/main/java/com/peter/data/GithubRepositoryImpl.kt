package com.peter.data

import com.peter.data.source.GithubRemoteSource
import com.peter.domain.model.GithubRepo
import com.peter.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteSource : GithubRemoteSource
) : GithubRepository {
    override suspend fun getRepos(owner: String): GithubRepo{
        return githubRemoteSource.getRepos(owner)
    }
}