package com.example.roomdatabaseexample.db

import androidx.room.*

@Dao // Тут описані всі запити
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users : List<User>)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}