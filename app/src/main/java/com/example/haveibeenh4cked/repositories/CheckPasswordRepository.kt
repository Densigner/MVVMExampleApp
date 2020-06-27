package com.example.haveibeenh4cked.repositories


import com.example.haveibeenh4cked.models.APIBadPassword
import com.example.haveibeenh4cked.models.DarkWebResults
import com.example.haveibeenh4cked.models.SafeApiRequest

class CheckPasswordRepository (

    private var api:APIBadPassword

) : SafeApiRequest() {

        suspend fun passwordResult(thePassword:String) : DarkWebResults {
            return apiRequest{ api.getthepassword(thePassword)}
        }

}










