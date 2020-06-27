package com.example.haveibeenh4cked.viewmodels.checkemail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.haveibeenh4cked.repositories.CheckDarkWebRepository


@Suppress("UNCHECKED_CAST")
class CheckEmailFactory(
    private val repository: CheckDarkWebRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CheckEmailViewModel(repository) as T
    }
}