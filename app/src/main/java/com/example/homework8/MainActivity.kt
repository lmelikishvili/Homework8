package com.example.homework8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val users = mutableListOf<User>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup(){
        insertUser()
        setUpRecycler()
    }

    private fun setUpRecycler(){
        binding.recycleUsers.layoutManager = LinearLayoutManager(this)
        binding.recycleUsers.adapter = UserRecyclerAdapter(users = users)

    }

    private fun insertUser(){
        users.also {
            it.add(User(name = "user1", email = "user1@asd.ge"))
            it.add(User(name = "user2", email = "user1@asd.ge"))
            it.add(User(name = "user3", email = "user1@asd.ge"))
            it.add(User(name = "user4", email = "user1@asd.ge"))
            it.add(User(name = "user5", email = "user1@asd.ge"))
            it.add(User(name = "user6", email = "user1@asd.ge"))
            it.add(User(name = "user7", email = "user1@asd.ge"))
            it.add(User(name = "user8", email = "user1@asd.ge"))
            it.add(User(name = "user9", email = "user1@asd.ge"))
            it.add(User(name = "user10", email = "user1@asd.ge"))
        }
    }
}