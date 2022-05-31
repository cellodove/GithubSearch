package com.peter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.LocalGithubRepo
import com.peter.domain.usecase.DeleteLocalGithubReposUseCase
import com.peter.domain.usecase.GetAllLocalGithubReposUseCase
import com.peter.domain.usecase.GetGithubReposUseCase
import com.peter.domain.usecase.SaveLocalGithubReposUseCase
import com.peter.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase,
    private val saveLocalGithubReposUseCase: SaveLocalGithubReposUseCase,
    private val deleteLocalGithubReposUseCase : DeleteLocalGithubReposUseCase,
    private val getAllLocalGithubReposUseCase : GetAllLocalGithubReposUseCase,
) : BaseViewModel() {

    private val _githubRepositories = MutableLiveData<GithubRepo>()
    val githubRepositories: LiveData<GithubRepo> = _githubRepositories

    private val _localRepositories = MutableLiveData<List<LocalGithubRepo>>()
    val resLocalRepositories: LiveData<List<LocalGithubRepo>> = _localRepositories

    fun getGithubRepositories(owner: String) {
        getGithubReposUseCase(owner, viewModelScope) {
            _githubRepositories.value = it
        }
    }

    fun bookmarkSave(item : LocalGithubRepo){
        saveLocalGithubReposUseCase.invoke(item,viewModelScope)
    }

    fun bookmarkDelete(item : LocalGithubRepo){
        deleteLocalGithubReposUseCase.invoke(item,viewModelScope)
    }

    fun bookmarkGet(){
        getAllLocalGithubReposUseCase.invoke(viewModelScope){
            _localRepositories.postValue(it)
        }
    }
}