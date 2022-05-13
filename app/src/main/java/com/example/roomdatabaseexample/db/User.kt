package com.example.roomdatabaseexample.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user") //  Всі поля які тут є використовуються шоб створити таблицю
data class User (
    @PrimaryKey (autoGenerate = true)
    val uid: Int,

    @ColumnInfo(name = "first_name")
    val firstName: String,

    @ColumnInfo(name = "last_name")
    val lastName: String

        ) {
    // Конвертація об'єкту в рядок
    override fun toString(): String {
        return "User(uid=$uid, firstName='$firstName', lastName='$lastName')"
    // Оскільки в нас не має передбачено UI-ки краще ці всі дані виводити в Logcat
    }
}
