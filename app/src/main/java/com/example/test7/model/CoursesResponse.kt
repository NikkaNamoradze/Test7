package com.example.test7.model


import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("active_courses")
    val activeCourses: List<ActiveCourse>,
    @SerializedName("new_courses")
    val newCourses: List<NewCourse>
)