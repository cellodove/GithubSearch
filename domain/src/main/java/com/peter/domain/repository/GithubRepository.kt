package com.peter.domain.repository

import com.peter.domain.model.GithubRepo

interface GithubRepository {
    suspend fun getRepos(owner : String) : GithubRepo
}