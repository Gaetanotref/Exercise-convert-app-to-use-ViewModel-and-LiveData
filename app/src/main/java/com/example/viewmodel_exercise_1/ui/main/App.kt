package com.example.viewmodel_exercise_1.ui.main

import android.app.Application
import com.example.viewmodel_exercise_1.ui.main.di.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext)
    }
}