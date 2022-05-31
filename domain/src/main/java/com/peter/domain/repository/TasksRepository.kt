package com.peter.domain.repository

import com.peter.domain.model.LocalGithubRepo
import com.peter.domain.model.GithubRepo

interface TasksRepository {
    fun saveItem(item: LocalGithubRepo)
    fun getAllItem(): List<LocalGithubRepo>
    fun deleteItem(item: LocalGithubRepo)
    suspend fun getRepos(owner : String) : GithubRepo

}