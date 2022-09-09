package com.example.test7.model


import com.google.gson.annotations.SerializedName

data class NewCourse(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("icon_type")
    val iconType: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("main_color")
    val mainColor: String,
    @SerializedName("question")
    val question: String,
    @SerializedName("title")
    val title: String
)