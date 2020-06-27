package com.example.haveibeenh4cked.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.example.haveibeenh4cked.R
import com.example.haveibeenh4cked.databinding.CheckPersonalInfoFragmentBinding
import com.example.haveibeenh4cked.models.DarkWebResults
import internal.ApiException
import internal.NoInternetException
import com.example.haveibeenh4cked.viewmodels.checkpersonalinfo.CheckPersonalInfoFactory
import com.example.haveibeenh4cked.viewmodels.checkpersonalinfo.CheckPersonalInfoViewModel
import kotlinx.android.synthetic.main.check_personal_info_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class CheckPersonalInfo : Fragment(),KodeinAware,OnRequestListener {
    /*
    This is an Example using Kodein and Coroutines.
    * */
    override val kodein by kodein()
    private val factory: CheckPersonalInfoFactory by instance()
    private lateinit var viewMode: CheckPersonalInfoViewModel
    companion object {
        fun newInstance() =
            CheckEmail()
    }


    lateinit var binding: CheckPersonalInfoFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.check_personal_info_fragment, container, false)
        viewMode = ViewModelProviders.of(this, factory).get(CheckPersonalInfoViewModel::class.java)
        viewMode.onRequest= this
        binding.viewmodelvar = viewMode
        binding.lifecycleOwner = this
        return binding.root;

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity)?.supportActionBar?.title = "Check Your Personal Info"

    }

    override fun onStarted() {
        Toast.makeText(activity,"Its Loading", Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(apiResponse: DarkWebResults) {}

    override fun onFailure(failuretext: String) {
        Toast.makeText(activity,failuretext, Toast.LENGTH_LONG).show()
    }

}