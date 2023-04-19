package com.example.viewmodel_exercise_1.ui.main.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCall {
    fun callRetrofit() : InterfaceCall {
         val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(InterfaceCall::class.java)
        return retrofit
    }
}