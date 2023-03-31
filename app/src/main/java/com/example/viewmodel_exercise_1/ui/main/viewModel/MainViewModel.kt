package com.example.viewmodel_exercise_1.ui.main.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.viewmodel_exercise_1.ui.main.DTO.MyDataItem
import com.example.viewmodel_exercise_1.ui.main.retrofit.RetrofitCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val retrofitCall = RetrofitCall().callRetrofit()

    private var _response = MutableLiveData<Response<List<MyDataItem>>>()
    val response : LiveData<Response<List<MyDataItem>>>
        get() = _response

    fun retriveRepos(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = retrofitCall.getData()
                    _response.postValue(result)

            }catch (e: Exception){
                Log.d("MainViewModel","ERROR : ${e.message},${e.cause}")
            }
        }
    }
}