package org.quesong.androidseminar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.quesong.androidseminar.databinding.FragmentSample2Binding

class SampleFragment2 : Fragment() {
    private var _binding: FragmentSample2Binding? = null
    private val binding get() = _binding ?: error("Binding 이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSample2Binding.inflate(layoutInflater, container, false)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_sampleFragment2_to_sampleFragment3)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
