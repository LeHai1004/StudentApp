package com.ute.studentapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ute.studentapp.databinding.FragmentStudentDetailBinding
import com.ute.studentapp.model.Student

class StudentDetailFragment : Fragment() {

    private var _binding: FragmentStudentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvId.text = "Mã SV: ${arguments?.getInt(ARG_ID)}"
        binding.tvName.text = "Họ tên: ${arguments?.getString(ARG_NAME)}"
        binding.tvMajor.text = "Ngành: ${arguments?.getString(ARG_MAJOR)}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_ID = "id"
        private const val ARG_NAME = "name"
        private const val ARG_MAJOR = "major"

        fun newInstance(student: Student): StudentDetailFragment {
            return StudentDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID, student.id)
                    putString(ARG_NAME, student.name)
                    putString(ARG_MAJOR, student.major)
                }
            }
        }
    }
}