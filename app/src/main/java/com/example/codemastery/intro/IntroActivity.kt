package com.example.codemastery.intro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.codemastery.R
import com.example.codemastery.main.MainActivity
import com.google.firebase.auth.FirebaseAuth

class IntroActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var auth :FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


auth = FirebaseAuth.getInstance()

        if(auth.currentUser!= null){
            val i  =    Intent(this , MainActivity::class.java)
            startActivity(i)
        }
        else{
            setContentView(R.layout.activity_intro)
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
            navController = navHostFragment.navController
        }
//        val sharedPref = getSharedPreferences("appPreferences", Context.MODE_PRIVATE)
//        val editor = sharedPref.edit()
//        editor.putBoolean("isFirstLaunch", false)
//        editor.apply()


        }



    }
