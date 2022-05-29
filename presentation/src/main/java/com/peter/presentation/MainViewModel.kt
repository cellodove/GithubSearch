package com.peter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.Item
import com.peter.domain.usecase.GetGithubReposUseCase
import com.peter.presentation.base.BaseViewModel
import com.peter.presentation.search.PagingRepository
import com.peter.presentation.search.SampleBackendService
import com.peter.presentation.search.SearchPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
    private val pagingRepository: PagingRepository
) : BaseViewModel() {

    private val _githubRepositories = MutableLiveData<GithubRepo>()
    val githubRepositories: LiveData<GithubRepo> = _githubRepositories

    fun getGithubRepositories(owner: String) {
        getGithubReposUseCase(owner, viewModelScope) {
            _githubRepositories.value = it
        }
    }

    fun getPageData(owner: String): Flow<PagingData<Item>>{
        return Pager(PagingConfig(pageSize = 10)){
            pagingRepository.getPagingData().map { pagingData ->

            }
        }
    }
}