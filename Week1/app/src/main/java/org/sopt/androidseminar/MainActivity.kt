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

        binding.btnLogin.setOnClickListener {
            initNetwork()
        }

        initClickEvent()
        isAutoLogin()

        setContentView(binding.root)
    }

    private fun initClickEvent() {
        binding.ibAutoLogin.setOnClickListener {
            binding.ibAutoLogin.isSelected = !binding.ibAutoLogin.isSelected

            SOPTSharedPreferences.setAutoLogin(this, binding.ibAutoLogin.isSelected)
        }
    }

    private fun isAutoLogin() {
        if(SOPTSharedPreferences.getAutoLogin(this)) {
            shortToast("자동로그인 완료")
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
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

                    shortToast("${response.body()?.data?.name}님 반갑습니다")

                    startActivity(Intent(this@MainActivity, SecondActivity::class.java))
                    finish()
                }
                else {

                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {

            }
        })
    }
}