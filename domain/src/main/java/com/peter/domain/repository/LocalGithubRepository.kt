package com.peter.domain.repository

import com.peter.domain.model.LocalGithubRepo

interface LocalGithubRepository {
    fun saveItem(item: LocalGithubRepo)
    fun getAllItem(): List<LocalGithubRepo>
    fun deleteItem(item: LocalGithubRepo)
}
