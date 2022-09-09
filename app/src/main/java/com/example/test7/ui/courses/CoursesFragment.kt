package com.example.test7.ui.courses

import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test7.R
import com.example.test7.adapter.ActiveCoursesAdapter
import com.example.test7.adapter.NewCoursesAdapter
import com.example.test7.databinding.CoursesFragmentBinding
import com.example.test7.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoursesFragment : BaseFragment<CoursesFragmentBinding>(CoursesFragmentBinding::inflate) {

    private val viewModel: CoursesViewModel by viewModels()

    private val newCourseAdapter by lazy {
        NewCoursesAdapter()
    }

    private val activeCourseAdapter by lazy {
        ActiveCoursesAdapter()
    }

    override fun start() {
        setUpRecyclers()
        observer()
    }

    private fun setUpRecyclers() {
        binding.rvNewCourses.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvNewCourses.adapter = newCourseAdapter

        binding.rvActiveCourses.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvActiveCourses.adapter = activeCourseAdapter
        binding.rvActiveCourses.hasFixedSize()
    }

    private fun observer() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loadCourses()
                viewModel.coursesFlow.collect {
                    newCourseAdapter.setData(it.data?.newCourses ?: emptyList())
                    activeCourseAdapter.setData(it.data?.activeCourses ?: emptyList())
                }
            }
        }
    }
}