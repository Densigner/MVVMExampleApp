package com.example.haveibeenh4cked.repositories

import com.example.haveibeenh4cked.models.APIDarkWeb
import com.example.haveibeenh4cked.models.DarkWebData
import com.example.haveibeenh4cked.models.SafeApiRequest


class CheckDarkWebRepository(

private var api:APIDarkWeb


): SafeApiRequest() {

    suspend fun checkTheDarkWeb(query: String) : DarkWebData {
        return apiRequest{ api.getDarkWebInfo(query,1)}
    }

}