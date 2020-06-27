package com.example.haveibeenh4cked.viewmodels.checkemail


import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haveibeenh4cked.repositories.CheckDarkWebRepository
import com.example.haveibeenh4cked.views.OnRequestListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CheckEmailViewModel(
    private val repository: CheckDarkWebRepository
):ViewModel() {
    var hasitbeenhacked = ObservableField<String>()
    var onRequest: OnRequestListener? = null
    var email:String? = null
        suspend fun checkTheDarkWebForEmail(
            query: String
        ) = withContext(Dispatchers.IO) { repository.checkTheDarkWeb(query) }

    fun onSubmitClicked() {
        if(email.isNullOrEmpty()){


            onRequest?.onFailure("A Field Is Empty")

            return

        }

        viewModelScope.launch(Dispatchers.Main) {

            onRequest?.onStarted()


            if (checkTheDarkWebForEmail(email!!).toString().contains(email!!)){

                hasitbeenhacked.set("Unfortunately An Exact Match Of Your Email Has Been Found On The Dark Web")
            }else{
                hasitbeenhacked.set("We Cant Find Your Email On The Dark Web")

            }
        }





    }
}