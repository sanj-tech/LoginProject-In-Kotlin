package com.example.roomdbtest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.lis.testdemo.sharedPreference.AndroidSharedPreference

class SplashScreenActivity : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initView()
    }

    private fun initView() {
        handler = Handler()
        handler.postDelayed({
            selectActivity()
        }, 1000)
    }
    fun selectActivity(){
        val isAlreadyLogin= AndroidSharedPreference(this).getIsAlreadyLogin()
        if (isAlreadyLogin){
            val intent=Intent(this,DetailInfoActivity::class.java)
            startActivity(intent)
        }
        else{
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}