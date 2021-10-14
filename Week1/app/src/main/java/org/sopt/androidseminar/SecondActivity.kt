package org.sopt.androidseminar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.androidseminar.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)

        binding.button.setOnClickListener {
            finish()
        }

        setContentView(binding.root)
    }
}