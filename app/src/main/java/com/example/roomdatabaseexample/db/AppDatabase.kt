package com.example.roomdatabaseexample.db

import androidx.room.Database
import androidx.room.RoomDatabase

//Використовується тільки одна єдина таблиця типу Entity під класом який називається User
// Версія - треба повідомляти шо змінілася структура бази данних
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}