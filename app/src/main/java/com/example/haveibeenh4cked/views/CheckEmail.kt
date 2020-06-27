package com.example.haveibeenh4cked.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.example.haveibeenh4cked.R

import com.example.haveibeenh4cked.databinding.CheckEmailFragmentBinding
import com.example.haveibeenh4cked.models.DarkWebResults
import internal.ApiException
import internal.NoInternetException
import com.example.haveibeenh4cked.viewmodels.checkemail.CheckEmailFactory

import com.example.haveibeenh4cked.viewmodels.checkemail.CheckEmailViewModel
import kotlinx.android.synthetic.main.check_email_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware

import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class CheckEmail : Fragment(),OnRequestListener,KodeinAware {
    /*
           This is an example of using databinding with MVVM architecture.

            */
    override val kodein by kodein()
    private val factory: CheckEmailFactory by instance()
    private lateinit var viewMode: CheckEmailViewModel
    companion object {
        fun newInstance() =
            CheckEmail()
    }


    lateinit var binding: CheckEmailFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.check_email_fragment, container, false)
        viewMode = ViewModelProviders.of(this, factory).get(CheckEmailViewModel::class.java)
        viewMode.onRequest= this
        binding.viewmodelvar = viewMode
        binding.lifecycleOwner = this
        return binding.root;

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity)?.supportActionBar?.title = "Check Email"

    }

    override fun onStarted() {
        Toast.makeText(activity,"Its Loading", Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(apiResponse: DarkWebResults) {}

    override fun onFailure(failuretext: String) {
        Toast.makeText(activity,failuretext, Toast.LENGTH_LONG).show()
    }

}
