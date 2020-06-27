package com.example.haveibeenh4cked.utilities

import android.app.Application
import com.example.haveibeenh4cked.models.APIBadPassword
import com.example.haveibeenh4cked.models.APIDarkWeb
import com.example.haveibeenh4cked.models.NetworkConnectionInterceptor
import com.example.haveibeenh4cked.repositories.CheckDarkWebRepository
import com.example.haveibeenh4cked.repositories.CheckPasswordRepository
import com.example.haveibeenh4cked.viewmodels.checkemail.CheckEmailFactory
import com.example.haveibeenh4cked.viewmodels.checkemail.CheckEmailViewModel
import com.example.haveibeenh4cked.viewmodels.checkpassword.CheckPasswordFactory
import com.example.haveibeenh4cked.viewmodels.checkpassword.CheckPasswordViewModel
import com.example.haveibeenh4cked.viewmodels.checkpersonalinfo.CheckPersonalInfoFactory
import com.example.haveibeenh4cked.viewmodels.checkpersonalinfo.CheckPersonalInfoViewModel

import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }

        //Check Email and Check Personal Info Use the same Repositories etc
        bind() from singleton { CheckEmailViewModel(instance()) }
        bind() from provider  { CheckEmailFactory(instance()) }
        bind() from singleton {  APIDarkWeb(instance())}
        bind() from singleton { CheckDarkWebRepository(instance()) }
        bind() from provider { CheckPersonalInfoFactory(instance())}
        bind() from singleton {CheckPersonalInfoViewModel (instance())}


//Check Password
        bind() from singleton { CheckPasswordViewModel(instance()) }
        bind() from provider { CheckPasswordFactory(instance()) }
        bind() from singleton {  APIBadPassword(instance())}
        bind() from singleton { CheckPasswordRepository(instance()) }



    }

}