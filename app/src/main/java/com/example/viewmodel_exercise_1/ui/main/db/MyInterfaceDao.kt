package com.example.viewmodel_exercise_1.ui.main.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface MyInterfaceDao {

    @Query("SELECT * FROM MyTable")
    fun getAll(): Flow<List<MyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users: MyEntity)
}