package com.example.codemastery.main

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
import com.example.codemastery.databinding.ActivityMainBinding
import com.example.codemastery.intro.IntroActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize the binding before calling setContentView
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Set the layout for MainActivity first

        // Setup window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Check if this is the first launch
        val sharedPref = getSharedPreferences("appPreferences", Context.MODE_PRIVATE)
        val isFirstLaunch = sharedPref.getBoolean("isFirstLaunch", true)

        if (isFirstLaunch) {
            // If it's the first launch, open IntroActivity
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
            finish()  // Close MainActivity so user can't return to it
        } else {
            // If not the first launch, setup navigation
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            navController = navHostFragment.navController
        }
    }
}
