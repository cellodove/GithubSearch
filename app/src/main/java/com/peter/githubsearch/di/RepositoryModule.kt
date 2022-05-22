package com.peter.githubsearch.di

import com.peter.data.GithubRepositoryImpl
import com.peter.domain.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesGithubRepository(repository: GithubRepositoryImpl): GithubRepository {
        return repository
    }
}