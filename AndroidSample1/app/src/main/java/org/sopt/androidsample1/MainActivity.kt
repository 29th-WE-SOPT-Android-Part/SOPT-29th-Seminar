package org.sopt.androidsample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidsample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.button.setOnClickListener {
            Toast.makeText(this, "안녕하세요 저는 문다빈입니다", Toast.LENGTH_SHORT).show()
        }

        setContentView(binding.root)
    }
}