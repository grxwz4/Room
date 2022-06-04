package com.example.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.database.User
//import com.android.volley.toolbox.JsonObjectRequest
import com.example.room.databinding.ItemListBinding

class MainAdapter(private val user: List<User>?): RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(user!![position])
    }

    class MainHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun render(user: User){
            binding.userName.setText("User name: " + user.user_name)
            binding.userId.setText("ID: " + user.user_id)
        }
    }

    override fun getItemCount(): Int {
        return user!!.size
    }
}