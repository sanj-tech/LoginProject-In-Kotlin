package com.example.roomdbtest.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PersonalInfo(
    var ownerName: String, var retailOutletName: String,
    var mobile_no1: String, var mobile_no2: String,
    var emailId: String, var dateOfBirth: String, var address_outlet: String, var city: String,
    var pin_code: String, var anvarsary: String
) {
    @PrimaryKey(autoGenerate = true)
    var columnId: Int = 0
}



