package com.peter.domain.repository

import com.peter.domain.model.GithubRepo
import com.peter.domain.model.LocalGithubItem

interface GithubRepository {
    suspend fun getRepos(owner : String) : GithubRepo

    suspend fun getAll() : List<LocalGithubItem>

    suspend fun insertItem(item: LocalGithubItem)

    suspend fun deleteItem(item: LocalGithubItem)
}