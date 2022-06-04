package com.example.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.database.DatabaseManager
import com.example.room.database.MyCoroutine
import com.example.room.database.User
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    fun saveUser(user: User){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.UserDao()
            MyCoroutine(userDao).save(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.UserDao()
            MyCoroutine(userDao).delete(user)
        }
    }


    //dao u o U
    val savedUsers = MutableLiveData<List<User>>()
    fun getUsers(){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.UserDao()
            savedUsers.value = MyCoroutine(userDao).getUsers().value
        }
    }
}