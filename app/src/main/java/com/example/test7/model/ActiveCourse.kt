package com.example.test7.model


import com.google.gson.annotations.SerializedName

data class ActiveCourse(
    @SerializedName("background_color_percent")
    val backgroundColorPercent: String,
    @SerializedName("booking_time")
    val bookingTime: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("main_color")
    val mainColor: String,
    @SerializedName("play_button_color_percent")
    val playButtonColorPercent: String,
    @SerializedName("progress")
    val progress: String,
    @SerializedName("title")
    val title: String
)