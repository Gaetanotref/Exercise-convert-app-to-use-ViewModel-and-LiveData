package com.example.viewmodel_exercise_1.ui.main.retrofit

import com.example.viewmodel_exercise_1.ui.main.dto.MyDataItem
import retrofit2.Response
import retrofit2.http.GET

interface InterfaceCall {
    @GET("posts")
    suspend fun getData(): List<MyDataItem>
}