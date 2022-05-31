package com.peter.presentation.search

import androidx.fragment.app.viewModels
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.Item
import com.peter.domain.usecase.GetGithubReposUseCase
import com.peter.domain.usecase.GetGithubReposUseCase2
import com.peter.presentation.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.random.Random

class SearchPagingSource @Inject constructor(
    private val getGithubReposUseCase2: GetGithubReposUseCase2,
) : PagingSource<Int, Item>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            delay(500)

            // 에러 발생 !
            if (Random.nextFloat() < 0.5) {
                throw Exception("error !!!")
            }

            val next = params.key ?: 1
            val owner = this.owner
            val scope = GlobalScope
            var response = listOf<Item>()
            getGithubReposUseCase2.invoke(owner,next,scope){
                response = it.item
            }

            LoadResult.Page(
                data = response,
                prevKey = if (next == 0) null else next - 1,
                nextKey = next + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}