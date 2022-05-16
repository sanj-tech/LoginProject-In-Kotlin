package com.example.roomdbtest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonalInfoDao {
    @Insert
    fun saveData(personalInfo: PersonalInfo)

    @Query("select * from PersonalInfo")
    fun getData(): List<PersonalInfo>

}