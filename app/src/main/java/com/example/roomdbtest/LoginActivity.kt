package com.example.roomdbtest

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.Toast
import com.example.roomdbtest.databinding.ActivityMainBinding
import com.lis.testdemo.sharedPreference.AndroidSharedPreference


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var androidSharedPreference: AndroidSharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        androidSharedPreference= AndroidSharedPreference(this)
        binding.btLogin.setOnClickListener({

            var UserName = binding.etUserName.text.toString()
            var UserPassword = binding.etPassword.text.toString()

//validaion of Login Page
            if (UserName.isBlank() && UserPassword.isBlank()) {
                Toast.makeText(this, "Please enter desired field", Toast.LENGTH_LONG).show()
                binding.etUserName.error = "Username Required"
                binding.etPassword.error = "Password Required"
                return@setOnClickListener
            } else
                if (!Patterns.EMAIL_ADDRESS.matcher(UserName).matches()) {
                    binding.etUserName.error = "Invalid Email Address"
                    return@setOnClickListener
                } else
                    if (UserPassword.length < 8) {
                        binding.etPassword.error = "Minimum 8 character required"
                    } else {
                        if (binding.checked.isChecked) {
                            androidSharedPreference.setIsAlreadyLogin(true)
                            androidSharedPreference.setString("userName", UserName)
                            androidSharedPreference.setString("userPassword", UserPassword)
                            Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show()
                            var intent = Intent(this, DetailInfoActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Please check Remember me", Toast.LENGTH_SHORT).show()
                        }
                    }
        })

    }


}