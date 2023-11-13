package com.example.homework8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework8.databinding.UserItemBinding

class UserRecyclerAdapter(private val users: MutableList<User>):RecyclerView.Adapter<UserRecyclerAdapter.UserVh>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVh {
        return UserVh(UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserVh, position: Int) {

    }


    inner class UserVh(private val binding: UserItemBinding):RecyclerView.ViewHolder(binding.root){

    }

}