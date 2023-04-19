package com.example.viewmodel_exercise_1.ui.main

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val retrofitCall = RetrofitCall().callRetrofit()

    val response = MutableSharedFlow<Response<List<MyDataItem>>>()


    fun retriveRepos() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = retrofitCall.getData()
                response.emit(result)

            } catch (e: Exception) {
                Log.d("MainViewModel", "ERROR : ${e.message},${e.cause}")
            }
        }
    }
}