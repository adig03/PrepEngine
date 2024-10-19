package com.example.codemastery.VideoLecture

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.codemastery.R
import com.example.codemastery.VideoLecture.Fragments.VideolistFragment

class VideoLectureActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_video_lecture)

        // Initialize NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView3) as NavHostFragment
        navController = navHostFragment.navController



        // Get the string from the Intent
        val myString = intent.getStringExtra("subject")

        // Create a Bundle to pass the data
        val bundle = Bundle()
        bundle.putString("subject", myString)

        navController.navigate(R.id.videolistFragment, bundle)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
