package org.sopt.androidseminar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.androidseminar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val intent = Intent(this, SecondActivity::class.java)

        binding.btnLogin.setOnClickListener {
            Toast.makeText(this, "안녕 난 다빈.", Toast.LENGTH_SHORT).show()

            startActivity(intent)
        }
        setContentView(binding.root)
    }
}