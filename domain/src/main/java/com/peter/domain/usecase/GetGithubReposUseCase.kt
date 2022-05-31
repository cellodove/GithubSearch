package com.peter.domain.usecase

import com.peter.domain.model.GithubRepo
import com.peter.domain.repository.GithubRepository
import com.peter.domain.repository.TasksRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetGithubReposUseCase(private val tasksRepository : TasksRepository) {
    operator fun invoke(
        owner : String,
        scope : CoroutineScope,
        onResult : (GithubRepo) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO){
                tasksRepository.getRepos(owner)
            }
            onResult(deferred.await())
        }
    }
}