package com.peter.data.source

import android.view.animation.Transformation
import androidx.lifecycle.Transformations
import androidx.lifecycle.Transformations.map
import com.peter.data.fromDomain
import com.peter.data.model.LocalGithubRepoRes
import com.peter.data.service.AppDatabase
import com.peter.data.toDomain
import com.peter.domain.model.LocalGithubRepo
import javax.inject.Inject


interface LocalGithubRemoteSource {
    fun saveItem(item: LocalGithubRepo)
    fun getAllItem(): List<LocalGithubRepo>
    fun deleteItem(item: LocalGithubRepo)
}

class LocalGithubRemoteSourceImpl@Inject constructor(
    private val appDatabase: AppDatabase
) : LocalGithubRemoteSource {
    override fun saveItem(item: LocalGithubRepo) {
        appDatabase.localDao().insertItem(item.fromDomain())
    }

    override fun getAllItem(): List<LocalGithubRepo> {
        return appDatabase.localDao().getAll() as List<LocalGithubRepo>
    }

    override fun deleteItem(item: LocalGithubRepo) {
        appDatabase.localDao().deleteItem(item.fromDomain())
    }
}