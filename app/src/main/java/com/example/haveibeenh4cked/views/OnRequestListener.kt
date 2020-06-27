package com.example.haveibeenh4cked.views

import com.example.haveibeenh4cked.models.DarkWebResults

interface OnRequestListener {
    fun onStarted()
    fun onSuccess(apiResponse: DarkWebResults)
    fun onFailure(failuretext:String)
}