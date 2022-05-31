package com.peter.domain.repository

import com.peter.domain.model.Bookmark

interface LocalGithubRepository {
    fun saveItem(item: Bookmark)
    fun getAllItem(): List<Bookmark>
    fun deleteItem(item: Bookmark)
}