package com.peter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.Item
import com.peter.domain.model.LocalGithubItem
import com.peter.domain.usecase.DeleteLocalGithubReposUseCase
import com.peter.domain.usecase.GetAllLocalGithubReposUseCase
import com.peter.domain.usecase.GetGithubReposUseCase
import com.peter.domain.usecase.SaveLocalGithubReposUseCase
import com.peter.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase,
    private val saveLocalGithubReposUseCase : SaveLocalGithubReposUseCase,
    private val deleteLocalGithubReposUseCase : DeleteLocalGithubReposUseCase,
    private val getAllLocalGithubReposUseCase : GetAllLocalGithubReposUseCase,

    ) : BaseViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val _githubRepositories = MutableLiveData<GithubRepo>()
    val githubRepositories: LiveData<GithubRepo> = _githubRepositories

    private val _localRepositories = MutableLiveData<List<LocalGithubItem>>()
    val localRepositories: LiveData<List<LocalGithubItem>> = _localRepositories

    fun getGithubRepositories(owner: String) {
        getGithubReposUseCase(owner, viewModelScope) {
            _githubRepositories.value = it
        }
    }

    fun bookmarkSave(item :Item){
        val localData = LocalGithubItem(login = item.login, url = item.url, avatarUrl = item.avatar_url, htmlUrl = item.html_url)
        scope.launch {
            saveLocalGithubReposUseCase(localData,viewModelScope)
        }
    }

    fun bookmarkDelete(item :Item){
        val localData = LocalGithubItem(login = item.login, url = item.url, avatarUrl = item.avatar_url, htmlUrl = item.html_url)
        scope.launch {
            deleteLocalGithubReposUseCase(localData,viewModelScope)
        }
    }

    fun bookmarkDeleteForLocal(item :LocalGithubItem){
        scope.launch {
            deleteLocalGithubReposUseCase(item,viewModelScope)
            bookmarkGet()
        }
    }

    fun bookmarkGet(){
        scope.launch {
            getAllLocalGithubReposUseCase(viewModelScope){
                _localRepositories.postValue(it)
            }
        }
    }
}