package com.example.roomdatabaseexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.roomdatabaseexample.db.AppDatabase
import com.example.roomdatabaseexample.db.User

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDatabase()
    }

    override fun onResume(){
        super.onResume()
        testDatabase()
    }

    private fun log(message: String) {
        Log.d("TEST_DB", message)
    }

    private fun testDatabase() {
        //  CREATE
           val user1 = User(1,"Ivan","Ivanenko")
           val user2 = User(2,"Petro","Petrenko")
           val user3 = User(3,"Vasyl","Vasylenko")
           val users = mutableListOf<User>()
           users.add(user1)
           users.add(user2)
           users.add(user3)

           db.userDao().insert(user1)
           log("insert $user1")
           db.userDao().insert(user2)
           log("insert $user2")
           db.userDao().insert(user3)
           log("insert $user3")

           db.userDao().insert(users)
           log("insert $users")

        //UPDATE
           val modifyUser = User(2,"NotPetro","NotPetrenko")
           db.userDao().update(modifyUser)
           log("update $user2")

        //DELETE
           db.userDao().delete(user3)
           log("delete $user3")


        //READ
           val readUsers = db.userDao().getAll()
           for (user in readUsers){
               log("read $user")
           }
    }


    private fun initDatabase() {
            db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "test-database"
        ).allowMainThreadQueries().build()

    }
}