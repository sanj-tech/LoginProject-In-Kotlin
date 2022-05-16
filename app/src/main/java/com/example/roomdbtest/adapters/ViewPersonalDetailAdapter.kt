package com.example.roomdbtest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbtest.R
import com.example.roomdbtest.db.PersonalInfo

class ViewPersonalDetailAdapter(
    var context: Context,
    var personalDetailList: List<PersonalInfo>
) : RecyclerView.Adapter<PersonalDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalDetailViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.custom_item_view, parent, false)
        return PersonalDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonalDetailViewHolder, position: Int) {
        holder.OwnerTxt.text = personalDetailList[position].ownerName
        holder.retailTxt.text = personalDetailList[position].emailId

    }

    override fun getItemCount(): Int {
        return personalDetailList.size
    }
}

class PersonalDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var OwnerTxt = itemView.findViewById<TextView>(R.id.txtOwner)
    var retailTxt = itemView.findViewById<TextView>(R.id.txtRetail)

}
