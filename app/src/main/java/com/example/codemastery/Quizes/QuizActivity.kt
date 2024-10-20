package com.example.codemastery.Quizes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.codemastery.R
import com.example.codemastery.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding :ActivityQuizBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)



        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView4) as NavHostFragment
        navController = navHostFragment.navController



    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}