package com.example.viewmodel_exercise_1.ui.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewmodel_exercise_1.R
import com.example.viewmodel_exercise_1.ui.main.ui.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}