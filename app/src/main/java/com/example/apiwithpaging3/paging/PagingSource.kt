package com.example.apiwithpaging3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.apiwithpaging3.models.Data
import com.example.apiwithpaging3.models.PersonModel
import com.example.apiwithpaging3.network.PersonApi

class PagingSource(private val api: PersonApi) : PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response: PersonModel = api.getPersonData(nextPageNumber)

            LoadResult.Page(
                data = response.data,
                prevKey = if (nextPageNumber > 1) nextPageNumber - 1 else null,
                nextKey = if (nextPageNumber < response.totalPages) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        TODO("Not yet implemented")
    }

}
