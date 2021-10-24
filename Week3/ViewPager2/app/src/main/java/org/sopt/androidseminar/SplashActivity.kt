package org.sopt.androidseminar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSplash()
        setContentView(R.layout.activity_splash)
    }

    private fun initSplash() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, SPLASH_VIEW_TIME)
    }

    companion object {
        const val SPLASH_VIEW_TIME = 2000L
    }
}
