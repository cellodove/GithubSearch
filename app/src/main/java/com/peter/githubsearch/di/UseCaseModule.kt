package com.peter.githubsearch.di

import com.peter.domain.repository.GithubRepository
import com.peter.domain.repository.TasksRepository
import com.peter.domain.usecase.DeleteLocalGithubReposUseCase
import com.peter.domain.usecase.GetAllLocalGithubReposUseCase
import com.peter.domain.usecase.GetGithubReposUseCase
import com.peter.domain.usecase.SaveLocalGithubReposUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetGithubReposUseCase(repository: TasksRepository): GetGithubReposUseCase {
        return GetGithubReposUseCase(repository)
    }

    @Provides
    fun providesSaveLocalGithubReposUseCase(repository: TasksRepository): SaveLocalGithubReposUseCase {
        return SaveLocalGithubReposUseCase(repository)
    }

    @Provides
    fun providesGetAllLocalGithubReposUseCase(repository: TasksRepository): GetAllLocalGithubReposUseCase {
        return GetAllLocalGithubReposUseCase(repository)
    }

    @Provides
    fun providesDeleteLocalGithubReposUseCase(repository: TasksRepository): DeleteLocalGithubReposUseCase {
        return DeleteLocalGithubReposUseCase(repository)
    }
}