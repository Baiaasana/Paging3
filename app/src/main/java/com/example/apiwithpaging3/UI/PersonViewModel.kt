package com.example.apiwithpaging3.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.apiwithpaging3.paging.PagingSource
import com.example.apiwithpaging3.network.PersonApi

class PersonViewModel(
    private val api: PersonApi
) : ViewModel() {
    val persons =
        Pager(config = PagingConfig(pageSize = 2, prefetchDistance = 2), pagingSourceFactory = {
            PagingSource(api)
        }).flow.cachedIn(viewModelScope)
}