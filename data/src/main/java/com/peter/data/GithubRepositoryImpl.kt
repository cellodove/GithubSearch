package com.peter.data

import com.peter.data.source.GithubRemoteSource
import com.peter.data.source.LocalGithubRemoteSource
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.LocalGithubItem
import com.peter.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteSource : GithubRemoteSource,
    private val localGithubRemoteSource : LocalGithubRemoteSource
) : GithubRepository {
    override suspend fun getRepos(owner: String): GithubRepo{
        return githubRemoteSource.getRepos(owner)
    }

    override suspend fun getAll(): List<LocalGithubItem> {
        return mapperToLocalGithubItem(localGithubRemoteSource.getAll())
    }

    override suspend fun insertItem(item: LocalGithubItem) {
        localGithubRemoteSource.insertItem(item.map())
    }

    override suspend fun deleteItem(item: LocalGithubItem) {
        localGithubRemoteSource.deleteItem(item.map())
    }
}