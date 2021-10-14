package org.sopt.androidseminar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.androidseminar.databinding.FragmentSampleBinding

class SampleFragment : Fragment() {
    private var _binding: FragmentSampleBinding? = null
    private val binding get() = _binding ?: error("Binding 이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSampleBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
