package com.example.haveibeenh4cked.viewmodels.checkpersonalinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.haveibeenh4cked.repositories.CheckDarkWebRepository


@Suppress("UNCHECKED_CAST")
class CheckPersonalInfoFactory(
    private val repository: CheckDarkWebRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CheckPersonalInfoViewModel(repository) as T
    }
}