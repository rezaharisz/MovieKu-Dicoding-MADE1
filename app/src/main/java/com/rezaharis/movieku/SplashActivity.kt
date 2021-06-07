@file:Suppress("DEPRECATION")

package com.rezaharis.movieku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private val displayLength = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        showSplash()
    }

    private fun showSplash(){
        Handler(mainLooper).postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            this@SplashActivity.startActivity(intent)
            finish()
        }, displayLength.toLong())
    }
}