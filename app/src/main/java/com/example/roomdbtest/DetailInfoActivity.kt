package com.example.roomdbtest

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.lis.testdemo.sharedPreference.AndroidSharedPreference

class DetailInfoActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailinfo)
        initView()
        updateNavigationView()

    }

    //Show header file data(Name,Password)
    private fun updateNavigationView() {
        val navView: NavigationView = findViewById(R.id.nav_view)

        var header: View = navView.getHeaderView(0)
        var txtuser = header.findViewById<TextView>(R.id.usertxtName)
        var txtdesig = header.findViewById<TextView>(R.id.usertxtDesignation)
        sharedPreferences =
            applicationContext.getSharedPreferences("loginPrefer", Context.MODE_PRIVATE)
        txtuser.setText(sharedPreferences.getString("userName", "UserName"))
        txtdesig.setText(sharedPreferences.getString("userPassword", "UserPassword"))

    }

    private fun initView() {
        var drawerLayout: DrawerLayout = findViewById(R.id.drawerlayout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        // navView.itemIconTintList
        navView.setItemIconTintList(null)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            var id = it.itemId
            if (id == R.id.menu_personal_detail) {
                var intent = Intent(this, PersonalDetailActivity::class.java)
                startActivity(intent)
            } else
                if (id == R.id.menu_view_detail) {
                    var intent = Intent(this, ViewPersonalDetailActivity::class.java)
                    startActivity(intent)
                } else if (id == R.id.menu_logout) {

                    AndroidSharedPreference(this).setIsAlreadyLogin(false)
                    var intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "No id selected", Toast.LENGTH_LONG).show()

                }

            true

        }
        //save login state

//        var loginState = getSharedPreferences("loginPrefer", Context.MODE_PRIVATE)
//        shareUserName.text = loginState.getString("userName", " ")
//        shareUserPass.text = loginState.getString("userPassword", " ")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}