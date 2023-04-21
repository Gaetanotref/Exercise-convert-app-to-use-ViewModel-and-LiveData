package com.example.viewmodel_exercise_1.ui.main.db

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [MyEntity::class], version = 1)
abstract class MyDataBase: RoomDatabase() {

    abstract fun getDAO() : MyInterfaceDao
}