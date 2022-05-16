package com.example.roomdbtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbtest.adapters.ViewPersonalDetailAdapter
import com.example.roomdbtest.databinding.ActivityViewPersonalDetailBinding
import com.example.roomdbtest.db.PersonalInfo
import com.example.roomdbtest.db.PersonalInfoRepository

class ViewPersonalDetailActivity() : AppCompatActivity() {
    lateinit var binding: ActivityViewPersonalDetailBinding
   // var personalDetailList = mutableListOf<PersonalInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPersonalDetailBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
//        personalDetailList.add(PersonalInfo("anu","Priyam"))
//        personalDetailList.add(PersonalInfo("anu","Priyam"))
//        personalDetailList.add(PersonalInfo("anu","Priyam"))

      val  personalDetailList = PersonalInfoRepository(this).getData()
        val myAdapter = ViewPersonalDetailAdapter(this, personalDetailList)

        Toast.makeText(this, "data is $myAdapter", Toast.LENGTH_SHORT).show()
        binding.personalDetailRcv.adapter = myAdapter

//
        //myAdapter.notifyDataSetChanged




    }
}