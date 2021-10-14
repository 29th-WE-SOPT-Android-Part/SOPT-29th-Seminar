package org.sopt.androidseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidseminar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var position = FIRST_POSITION
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        initTransactionEvent()

        setContentView(binding.root)
    }

    private fun initTransactionEvent() {
        val fragment1 = SampleFragment()
        val fragment2 = SampleFragment2()

        supportFragmentManager.beginTransaction().add(R.id.container_main, fragment1).commit()

        binding.btnChange.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position) {
                FIRST_POSITION -> {
                    transaction.replace(R.id.container_main, fragment2)
                    position = SECOND_POSITION
                }
                SECOND_POSITION -> {
                    transaction.replace(R.id.container_main, fragment1)
                    position = FIRST_POSITION
                }
            }
            transaction.commit()
        }
    }

    companion object {
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2
    }
}