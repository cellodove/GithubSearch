package com.peter.presentation.search

import androidx.lifecycle.viewModelScope
import com.peter.domain.model.Item
import com.peter.domain.usecase.GetGithubReposUseCase
import kotlinx.coroutines.GlobalScope
import javax.inject.Inject

class SampleBackendService @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
) {

    /**
     * Sample
     */
    fun getPagingData(owner :String ,page: Int): PagingSample {
        var result = listOf<Item>()
        val result2  = mutableListOf<Item>()

        val scope = GlobalScope
        getGithubReposUseCase(owner, scope) {
            result = it.item
        }

        return PagingSample(
            data = result,
            page = page + 1
        )
    }
}