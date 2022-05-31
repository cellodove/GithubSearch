package com.peter.data

import com.peter.data.source.GithubRemoteSource
import com.peter.data.source.LocalGithubRemoteSource
import com.peter.domain.model.LocalGithubRepo
import com.peter.domain.model.GithubRepo
import com.peter.domain.repository.TasksRepository
import javax.inject.Inject

class TasksRepositoryImpl@Inject constructor(
    private val githubRemoteSource : GithubRemoteSource,
    private val localGithubRemoteSource : LocalGithubRemoteSource
) : TasksRepository {

    override fun saveItem(item: LocalGithubRepo) {
        localGithubRemoteSource.saveItem(item)
    }

    override fun getAllItem(): List<LocalGithubRepo> {
        return localGithubRemoteSource.getAllItem()
    }

    override fun deleteItem(item: LocalGithubRepo) {
        localGithubRemoteSource.deleteItem(item)
    }

    override suspend fun getRepos(owner: String): GithubRepo {
        return githubRemoteSource.getRepos(owner)
    }
}