package org.sopt.androidseminar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.androidseminar.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val intent = Intent(this, SecondActivity::class.java)

        binding.btnLogin.setOnClickListener {
            initNetwork()
        }
        setContentView(binding.root)
    }

    private fun initNetwork() {
        val requestLoginData = RequestLoginData(
            binding.etId.text.toString(),
            binding.etPass.text.toString()
        )

        val call : Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)

        call.enqueue(object : Callback<ResponseLoginData>{
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if(response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "${response.body()?.data?.name}님 반갑습니다", Toast.LENGTH_SHORT).show()

                    startActivity(Intent(this@MainActivity, SecondActivity::class.java))
                }
                else {

                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {

            }
        })
    }
}