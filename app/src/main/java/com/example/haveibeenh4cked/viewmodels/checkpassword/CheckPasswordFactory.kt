package com.example.haveibeenh4cked.viewmodels.checkpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.haveibeenh4cked.repositories.CheckPasswordRepository

@Suppress("UNCHECKED_CAST")
class CheckPasswordFactory(
    private val repository: CheckPasswordRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CheckPasswordViewModel(repository) as T
    }
}