package com.example.haveibeenh4cked.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.haveibeenh4cked.R
import com.example.haveibeenh4cked.viewmodels.checkpassword.CheckPasswordViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this,
            R.id.nav_host_fragment
        )
bottomNavigationView.setupWithNavController(navController)

NavigationUI.setupActionBarWithNavController(this,navController)

    }
    override fun onSupportNavigateUp():Boolean {


        return NavigationUI.navigateUp(navController,null)
    }

}
