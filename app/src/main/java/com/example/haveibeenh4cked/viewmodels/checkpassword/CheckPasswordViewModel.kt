package com.example.haveibeenh4cked.viewmodels.checkpassword

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.example.haveibeenh4cked.repositories.CheckPasswordRepository
import com.example.haveibeenh4cked.views.OnRequestListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CheckPasswordViewModel(
    private val repository: CheckPasswordRepository

): ViewModel(){
var onRequest:OnRequestListener? = null
var password:String? = null

    var hasitbeenhacked = ObservableField<String>()


    suspend fun checkTheDarkWeb(
        password: String

    ) = withContext(Dispatchers.IO) { repository.passwordResult(password) }

/// Called via Databinding
 fun onSubmitClicked() {
        if(password.isNullOrEmpty()){


            onRequest?.onFailure("A Field Is Empty")

            return

        }

    viewModelScope.launch(Dispatchers.Main) {

        onRequest?.onStarted()


        if (checkTheDarkWeb(password!!).toString().contains("true")){

            hasitbeenhacked.set("Unfortunately Your Password Has Been Compromised")
        }else{
            hasitbeenhacked.set("Your Password Has Not Been Found Within Our Database")

        }
    }





    }

}

