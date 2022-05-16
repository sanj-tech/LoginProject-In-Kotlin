package com.example.roomdbtest.db

import android.content.Context

class PersonalInfoRepository(context: Context) {
    var personalInfoDao = HelloDB?.getInstance(context).personalInfoDao()

    fun saveData(personalInfo: PersonalInfo) {
        personalInfoDao.saveData(personalInfo)
    }

    fun getData(): List<PersonalInfo> {
        return personalInfoDao.getData()
    }
}
