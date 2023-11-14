package com.example.homework8

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val users = mutableListOf<User>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecycler()
        binding.btnAdd.setOnClickListener(){addInfo()}


    }
        private fun setUpRecycler(){
        binding.recycleUsers.layoutManager = LinearLayoutManager(this)
        binding.recycleUsers.adapter = UserRecyclerAdapter(users = users)

    }

    private fun addInfo() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_user,null)
        /**set view*/
        val userName = v.findViewById<EditText>(R.id.userName)
        val email = v.findViewById<EditText>(R.id.email)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
                dialog,_->
            val name = userName.text.toString()
            val email = email.text.toString()
            users.add(User("Name: $name","Email : $email"))
            //UserRecyclerAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Adding User Information Success",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()

        }
        addDialog.create()
        addDialog.show()
    }

}