package com.example.apiwithpaging3.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apiwithpaging3.network.PersonApi

class PersonViewModelFactory(private val api: PersonApi) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonViewModel(api) as T
    }
}