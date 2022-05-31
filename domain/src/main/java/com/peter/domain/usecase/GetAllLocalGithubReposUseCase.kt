package com.peter.domain.usecase

import com.peter.domain.model.LocalGithubRepo
import com.peter.domain.repository.TasksRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetAllLocalGithubReposUseCase(private val tasksRepository : TasksRepository) {
    operator fun invoke(
        scope : CoroutineScope,
        onResult : (List<LocalGithubRepo>) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO){
                tasksRepository.getAllItem()
            }
            onResult(deferred.await())
        }
    }
}