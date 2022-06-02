package com.peter.githubsearch.di

import com.peter.data.source.GithubRemoteSource
import com.peter.data.source.GithubRemoteSourceImpl
import com.peter.data.source.LocalGithubRemoteSource
import com.peter.data.source.LocalGithubRemoteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun providesGithubRemoteSource(source: GithubRemoteSourceImpl): GithubRemoteSource {
        return source
    }

    @Singleton
    @Provides
    fun providesLocalGithubRemoteSource(source: LocalGithubRemoteSourceImpl): LocalGithubRemoteSource {
        return source
    }
}