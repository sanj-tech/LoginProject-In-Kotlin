package com.example.roomdbtest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonalInfo::class], version = 1, exportSchema = false)
abstract class HelloDB() : RoomDatabase() {

    abstract fun personalInfoDao(): PersonalInfoDao

    companion object {
        var instance: HelloDB? = null

        @Synchronized
        fun getInstance(context: Context): HelloDB {
            if (instance == null)

                instance = Room.databaseBuilder(
                    context.applicationContext,
                    HelloDB::class.java, "HelloDb"
                ).allowMainThreadQueries().build()

            return instance!!
        }


    }
}