package com.example.test7.ui.courses

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test7.model.CoursesResponse
import com.example.test7.repository.CoursesRepository
import com.example.test7.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoursesViewModel @Inject constructor(private val repository: CoursesRepository) : ViewModel() {

    private var _courseFlow = MutableSharedFlow<Resource<CoursesResponse>>()
    val coursesFlow = _courseFlow.asSharedFlow()

    suspend fun loadCourses(){
        viewModelScope.launch {
            _courseFlow.emit(repository.getCourses())
        }
    }
}