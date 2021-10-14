package org.sopt.androidseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidseminar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var followerAdapter: FollowerAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initAdapter()

        setContentView(binding.root)
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter()

        binding.rvFollower.adapter = followerAdapter

        followerAdapter.userList.addAll(
            listOf(
                UserData("문다빈", "안드로이드 파트장"),
                UserData("김현아", "기획 파트장"),
                UserData("이성현", "디자인 파트장"),
                UserData("장혜령", "iOS 파트장"),
                UserData("김우영", "서버 파트장"),
                UserData("김의진", "웹 파트장")
            )
        )

        followerAdapter.notifyDataSetChanged()
    }
}
