package com.peter.data.source

import com.peter.data.model.GithubRepoRes
import com.peter.data.model.LocalGithubRepoRes
import com.peter.data.service.AppDatabase
import com.peter.data.service.GithubService
import com.peter.domain.model.Bookmark
import javax.inject.Inject


interface LocalGithubRemoteSource {
    fun saveItem(item: LocalGithubRepoRes)
    fun getAllItem(): List<LocalGithubRepoRes>
    fun deleteItem(item: LocalGithubRepoRes)
}


class LocalGithubRemoteSourceImpl@Inject constructor(
    private val appDatabase: AppDatabase
) : LocalGithubRemoteSource {
    override fun saveItem(item: LocalGithubRepoRes) {
        appDatabase.localDao().insertItem(item)
    }

    override fun getAllItem(): List<LocalGithubRepoRes> {
        return appDatabase.localDao().getAll()
    }

    override fun deleteItem(item: LocalGithubRepoRes) {
        appDatabase.localDao().deleteItem(item)
    }
}