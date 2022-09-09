package com.example.test7.di

import com.example.test7.newtork.CoursesApi
import com.example.test7.repository.CoursesRepository
import com.example.test7.repository.CoursesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://run.mocky.io/v3/"

    @Provides
    @Singleton
    fun provideCoursesApi(): CoursesApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoursesApi::class.java)

    @Provides
    @Singleton
    fun provideCoursesRepository(api: CoursesApi): CoursesRepository = CoursesRepositoryImpl(api)
}