package org.sopt.androidseminar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.androidseminar.databinding.FragmentEmpty1Binding

class EmptyFragment1 : Fragment() {
    private var _binding: FragmentEmpty1Binding? = null
    private val binding get() = _binding ?: error("Binding 이 초기화 되지 않았습니다.")
    private lateinit var sampleViewPagerAdapter: SampleTabViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmpty1Binding.inflate(layoutInflater, container, false)

        initAdapter()
        initImage()
        initTabLayout()

        return binding.root
    }

    private fun initImage() {
        Glide.with(this)
            .load("https://avatars.githubusercontent.com/u/89780201?s=200&v=4")
            .circleCrop()
            .into(binding.ivProfile)
    }

    private fun initAdapter() {
        val fragmentList = listOf(TabFragment1(), TabFragment2())

        sampleViewPagerAdapter = SampleTabViewPagerAdapter(this)
        sampleViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpSample.adapter = sampleViewPagerAdapter
    }

    private fun initTabLayout() {
        val tabLabel = listOf("첫 번째", "두 번째")

        TabLayoutMediator(binding.tlSample, binding.vpSample) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}