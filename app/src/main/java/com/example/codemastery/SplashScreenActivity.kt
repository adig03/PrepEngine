package com.example.codemastery

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.WindowManager
import com.example.codemastery.intro.IntroActivity
import com.example.codemastery.main.MainActivity
import com.google.firebase.auth.FirebaseAuth

@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        supportActionBar?.hide()
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)


        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser


        Handler(Looper.getMainLooper()).postDelayed({
            if (currentUser != null) {

                startActivity(Intent(this, MainActivity::class.java))
            } else {

                startActivity(Intent(this, IntroActivity::class.java))
            }

            finish()
        }, 5000)
    }
}
