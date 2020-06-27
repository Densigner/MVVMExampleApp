package com.example.haveibeenh4cked.models

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.security.MessageDigest

interface APIBadPassword{
var password:String
    @Headers("Authorization: d036abb5-6f62-49aa-af5d-b7d4419e605f")
@GET("check/{password}")
    suspend  fun getthepassword(

        @Path("password") password: String

    ):Response<DarkWebResults>

companion object{
    operator fun invoke(
        networkConnectionInterceptor: NetworkConnectionInterceptor
    ) : APIBadPassword {

        val okkHttpclient = OkHttpClient.Builder()
            .addInterceptor(networkConnectionInterceptor)
            .build()

        return Retrofit.Builder()
            .client(okkHttpclient)
            .baseUrl("https://api.badpasswordcheck.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIBadPassword::class.java)
    }
}

}