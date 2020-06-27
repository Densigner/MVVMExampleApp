package com.example.haveibeenh4cked.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.haveibeenh4cked.databinding.CheckPasswordFragmentBinding
import com.example.haveibeenh4cked.models.DarkWebResults
import com.example.haveibeenh4cked.viewmodels.checkpassword.CheckPasswordFactory
import com.example.haveibeenh4cked.viewmodels.checkpassword.CheckPasswordViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class CheckPassword : Fragment() ,OnRequestListener,KodeinAware{
    /*
        This is an example of using databinding with MVVM architecture.

         */
    companion object {
        fun newInstance() =
            CheckPassword()
    }

    override val kodein by kodein()
    private val factory: CheckPasswordFactory by instance()


    lateinit var binding: CheckPasswordFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CheckPasswordFragmentBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        return binding.root;

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       val viewMode = ViewModelProviders.of(this, factory).get(CheckPasswordViewModel::class.java)
        viewMode.onRequest= this
        binding.viewmodelvar = viewMode
        (activity as MainActivity)?.supportActionBar?.title = "Check Password"

    }

    override fun onStarted() {
       Toast.makeText(activity,"Its Loading", Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(apiResponse: DarkWebResults) {

    }





    override fun onFailure(failuretext: String) {
Toast.makeText(activity,failuretext,Toast.LENGTH_LONG).show()
    }

}
