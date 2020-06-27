package com.example.haveibeenh4cked.viewmodels.checkpersonalinfo

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.haveibeenh4cked.repositories.CheckDarkWebRepository
import com.example.haveibeenh4cked.views.OnRequestListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CheckPersonalInfoViewModel(   private val repository: CheckDarkWebRepository
):ViewModel() {
    var personalinfo:String? = null
    var hasitbeenhacked = ObservableField<String>()
    var onRequest: OnRequestListener? = null
    suspend fun checkTheDarkWebforPersonalInfo(
        query: String

    ) = withContext(Dispatchers.IO) { repository.checkTheDarkWeb(query) }


    fun onSubmitClicked() {
        if(personalinfo.isNullOrEmpty()){


            onRequest?.onFailure("A Field Is Empty")

            return

        }

        viewModelScope.launch(Dispatchers.Main) {

            onRequest?.onStarted()


            if (checkTheDarkWebforPersonalInfo(personalinfo!!).toString().contains(personalinfo!!)){

                hasitbeenhacked.set("Unfortunately An Exact Match Of Your Personal Information Has Been Found On The Dark Web")
            }else{
                hasitbeenhacked.set("We Cant Find Your Personal Info On The Dark Web")

            }
        }

}



}