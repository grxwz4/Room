package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.room.database.User
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var id: Int = 0
    private lateinit var queue: RequestQueue
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        queue = Volley.newRequestQueue(this)

        binding.enter.setOnClickListener {

            mainViewModel.getUsers()
            mainViewModel.savedUsers.observe(this) { usersList ->
                if (!usersList.isNullOrEmpty()) {
                    var c: Int = 0
                    for (user in usersList) {
                        c += 1
                    }
                    id = c
                } else {
                    id = 0
                }
            }

            mainViewModel.saveUser(User(
                "userID" + String.format("%04d", id),
                binding.name.text.toString()
            ))

            mainViewModel.getUsers()
            mainViewModel.savedUsers.observe(this) { usersList ->
                if (!usersList.isNullOrEmpty()) {
                    for (user in usersList) {
                        Log.d("thesearetheusers", user.user_name + " *x*x* " + user.user_id)
                    }
                } else {
                    Log.d("thesearetheusers", "null or empty")
                }
                val list: List<User>? = usersList
                binding.list.adapter = MainAdapter(list)
            }

            binding.name.setText("")
        }

        mainViewModel.getUsers()
        mainViewModel.savedUsers.observe(this) { usersList ->
            if (!usersList.isNullOrEmpty()) {
                for (user in usersList) {
                    Log.d("thesearetheusers", user.user_name + " *x*x* " + user.user_id)
                }
            } else {
                Log.d("thesearetheusers", "null or empty")
            }
            val list: List<User>? = usersList
            binding.list.adapter = MainAdapter(list)
        }

    }
}