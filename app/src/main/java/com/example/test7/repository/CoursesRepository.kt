package com.example.test7.repository

import com.example.test7.model.CoursesResponse
import com.example.test7.util.Resource
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {
    suspend fun getCourses(): Resource<CoursesResponse>
}