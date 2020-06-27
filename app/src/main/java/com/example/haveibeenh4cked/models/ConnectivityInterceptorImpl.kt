package com.example.haveibeenh4cked.models

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import internal.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptorImpl(

    context: Context
) : ConnectivityInterceptor {

    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
  if(!isOnline()){

 throw NoInternetException("You Are Not Online")


  }
        return chain.proceed(chain.request())
    }


    private fun isOnline():Boolean {
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager

        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}