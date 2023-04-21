package com.example.viewmodel_exercise_1.ui.main.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.viewmodel_exercise_1.ui.main.dto.MyDataItem

@Entity(tableName = "MyTable")
data class MyEntity (
        @PrimaryKey val id: Int,
        @ColumnInfo(name = "body")val body : String,
        @ColumnInfo(name = "title")val title: String,
        @ColumnInfo(name = "userId")val userId: Int
        )

fun MyEntity.toModel(): MyDataItem {
        return MyDataItem(id = this.id, body = this.body,title = this.title,userId = this.userId)
}

fun MyDataItem.toEntity() : MyEntity{
        return MyEntity(id = this.id, body = this.body,title = this.title,userId = this.userId)
}