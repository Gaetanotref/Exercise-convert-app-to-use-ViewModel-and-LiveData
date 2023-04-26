package com.example.viewmodel_exercise_1.ui.main.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodel_exercise_1.ui.main.db.MyInterfaceDao
import com.example.viewmodel_exercise_1.ui.main.db.toEntity
import com.example.viewmodel_exercise_1.ui.main.db.toModel
import com.example.viewmodel_exercise_1.ui.main.dto.MyDataItem
import com.example.viewmodel_exercise_1.ui.main.retrofit.RetrofitCall
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MainViewModel(val myDao: MyInterfaceDao) : ViewModel() {

    private val retrofitCall = RetrofitCall().callRetrofit()


    var response = MutableSharedFlow<List<MyDataItem>>()

    init {
        setupDatabaseObserver()
    }

    private fun setupDatabaseObserver() {
        viewModelScope.launch {
            myDao.getAll().collect {
                Log.d("MainViewModel", "retrieved from database")
                it.map { myEntity -> myEntity.toModel() }.let { it1 -> response.emit(it1) }
            }
        }
    }

    fun retriveRepos() {
        viewModelScope.launch {
            try {
                val resultFromNetwork = retrofitCall.getData()
                myDao.insertAll(*resultFromNetwork.map { repo -> repo.toEntity() }.toTypedArray())
            } catch (e: Exception) {
                Log.d("MainViewModel", "ERROR : ${e.message},${e.cause}")
            }
        }
    }
}