package com.example.homework8

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.persistableBundleOf
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
        val user = users[position]
        holder.name.text = user.name
        holder.email.text = user.email

    }

    @SuppressLint("MissingInflatedId")
    inner class UserVh(private val binding: UserItemBinding):RecyclerView.ViewHolder(binding.root){
        val name = binding.tvNameSurname
        val email = binding.tvEmail
        private val edit = binding.btnEdit
        val delete = binding.btnDelete

        init {
            edit.setOnClickListener(){
                val v = LayoutInflater.from(it.context).inflate(R.layout.add_user,null)
                val name = v.findViewById<EditText>(R.id.userName)
                val email = v.findViewById<EditText>(R.id.email)
                v.findViewById<TextView>(R.id.addHeader).text = "Edit User"
                AlertDialog.Builder(it.context)
                    .setView(v)
                    .setPositiveButton("OK"){
                            _, _->
                        users[adapterPosition].name = "Name: ${name.text}"
                        users[adapterPosition].email = "Email: ${email.text}"
                        notifyDataSetChanged()
                        Toast.makeText(it.context,"User Details Edited", Toast.LENGTH_LONG).show()
                    }
                    .setNegativeButton("Cancel"){
                            _, _->
                    }
                    .create()
                    .show()
            }

            delete.setOnClickListener(){
                AlertDialog.Builder(it.context)
                    .setTitle("Delete User?")
                    .setIcon(R.drawable.delete)
                    .setMessage("User Will Deleted!!")
                    .setPositiveButton("Yes"){
                        _,_->
                        users.removeAt(adapterPosition)
                        notifyDataSetChanged()
                        Toast.makeText(it.context,"User Deleted!!", Toast.LENGTH_LONG).show()
                    }
                    .setNegativeButton("No"){
                        _,_->
                    }
                    .create()
                    .show()
            }

        }





    }

}