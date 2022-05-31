package com.peter.data

import com.peter.data.source.GithubRemoteSource
import com.peter.domain.model.Bookmark
import com.peter.domain.model.GithubRepo
import com.peter.domain.repository.TasksRepository
import javax.inject.Inject

class TasksRepositoryImpl@Inject constructor(
    private val githubRemoteSource : GithubRemoteSource
) : TasksRepository {


    override fun saveItem(item: Bookmark) {
        TODO("Not yet implemented")
    }

    override fun getAllItem(): List<Bookmark> {
        TODO("Not yet implemented")
    }

    override fun deleteItem(item: Bookmark) {
        TODO("Not yet implemented")
    }

    override suspend fun getRepos(owner: String): GithubRepo {
        return githubRemoteSource.getRepos(owner)
    }
}