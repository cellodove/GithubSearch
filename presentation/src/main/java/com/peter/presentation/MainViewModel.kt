package com.peter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.peter.data.LocalRepository
import com.peter.data.model.LocalGithubRepo
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.Item
import com.peter.domain.repository.GithubRepository
import com.peter.domain.usecase.GetGithubReposUseCase
import com.peter.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase,
    private val localRepository: LocalRepository
) : BaseViewModel() {

    private val _githubRepositories = MutableLiveData<GithubRepo>()
    val githubRepositories: LiveData<GithubRepo> = _githubRepositories

    fun getGithubRepositories(owner: String) {
        getGithubReposUseCase(owner, viewModelScope) {
            _githubRepositories.value = it
        }
    }

    fun bookmarkSave(item :Item){
        val localData = LocalGithubRepo(login = item.login, url = item.url, avatar_url = item.avatar_url, html_url = item.html_url)
        viewModelScope.launch {
            localRepository.saveItem(localData)
        }
    }
}