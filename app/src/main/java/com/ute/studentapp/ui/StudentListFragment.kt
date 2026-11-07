package com.ute.studentapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.ute.studentapp.R
import com.ute.studentapp.databinding.FragmentStudentListBinding
import com.ute.studentapp.model.Student

class StudentListFragment : Fragment() {

    private var _binding: FragmentStudentListBinding? = null
    private val binding get() = _binding!!

    private val students = listOf(
        Student(1, "Lê Hoàng Hải", "Công nghệ thông tin"),
        Student(2, "Phạm Minh Quốc", "Kỹ thuật phần mềm"),
        Student(3, "Võ Thanh Duy", "Hệ thống thông tin"),
        Student(4, "Đặng Thùy Linh", "Công nghệ thông tin"),
        Student(5, "Huỳnh Gia Bảo", "An toàn thông tin")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val names = students.map { it.name }
        binding.lvStudents.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            names
        )

        binding.lvStudents.setOnItemClickListener { _, _, position, _ ->
            val detail = StudentDetailFragment.newInstance(students[position])
            parentFragmentManager.commit {
                replace(R.id.fragmentContainer, detail)
                addToBackStack(null)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}