package com.example.addatwentyfour.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.addatwentyfour.R
import com.example.addatwentyfour.databinding.ListRowBinding
import com.example.addatwentyfour.model.UserDataModel

class MyAdapter(): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var list: ArrayList<UserDataModel> = ArrayList()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ListRowBinding? = DataBindingUtil.bind(itemView)

        fun setModel(user: UserDataModel){
            binding?.user = user
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setModel(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(updateList: ArrayList<UserDataModel> ){
       list.addAll(updateList)
       notifyDataSetChanged()
    }
}