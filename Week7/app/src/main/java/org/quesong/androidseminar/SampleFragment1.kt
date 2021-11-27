package org.quesong.androidseminar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.quesong.androidseminar.databinding.FragmentSample1Binding

class SampleFragment1 : Fragment() {
    private var _binding: FragmentSample1Binding? = null
    private val binding get() = _binding ?: error("Binding 이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSample1Binding.inflate(layoutInflater, container, false)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_sampleFragment1_to_sampleFragment2)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
