package com.example.test7.newtork

import com.example.test7.model.CoursesResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoursesApi {
    @GET("4167a598-b68c-420f-b6e1-fef68b89a10d")
    suspend fun getCourses() : Response<CoursesResponse>
}