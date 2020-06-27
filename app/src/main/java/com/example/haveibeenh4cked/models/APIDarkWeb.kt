package com.example.haveibeenh4cked.models

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface APIDarkWeb {



@GET("api/search/")


suspend fun getDarkWebInfo(
    @Query("query") query:String,
@Query("page") page:Int
    ):Response<DarkWebData>
    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : APIDarkWeb{

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                    //
                .baseUrl("https://darksearch.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIDarkWeb::class.java)
        }
    }

}