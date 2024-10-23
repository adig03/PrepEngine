package com.example.codemastery.Questions

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.codemastery.R
import com.example.codemastery.databinding.ActivityQuestionBinding


class QuestionActivity : AppCompatActivity() {
    private lateinit var navController:NavController
    private lateinit var binding: ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView5) as NavHostFragment
        navController = navHostFragment.navController
        val myString = intent.getStringExtra("subtopic")
        val bundle = Bundle()
        bundle.putString("subtopic", myString )


        navController.navigate(R.id.questionListFragment, bundle)


    }
}