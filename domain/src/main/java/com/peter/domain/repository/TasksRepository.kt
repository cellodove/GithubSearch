package com.peter.domain.repository

import com.peter.domain.model.Bookmark
import com.peter.domain.model.GithubRepo

interface TasksRepository {
    fun saveItem(item: Bookmark)
    fun getAllItem(): List<Bookmark>
    fun deleteItem(item: Bookmark)

    suspend fun getRepos(owner : String) : GithubRepo

}