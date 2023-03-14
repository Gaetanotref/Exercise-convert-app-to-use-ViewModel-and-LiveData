package com.example.viewmodel_exercise_1.ui.main

import retrofit2.Response
import retrofit2.http.GET

interface InterfaceCall {
    @GET("posts")
    suspend fun getData(): Response<List<MyDataItem>>
}