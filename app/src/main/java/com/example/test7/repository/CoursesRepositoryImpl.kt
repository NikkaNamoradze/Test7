package com.example.test7.repository

import com.example.test7.model.CoursesResponse
import com.example.test7.newtork.CoursesApi
import com.example.test7.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(private val api: CoursesApi) : CoursesRepository {

    override suspend fun getCourses(): Resource<CoursesResponse> {
        return try {
            val response = api.getCourses()
            val body = response.body()
            if (response.isSuccessful && body != null){
                Resource.Success(body)
            }else{
                Resource.Failure(response.message())
            }
        }catch (e: Throwable){
            Resource.Failure(e.message.toString())
        }
    }
}

