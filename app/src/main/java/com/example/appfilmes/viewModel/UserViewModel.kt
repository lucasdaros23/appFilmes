package com.example.appfilmes.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appfilmes.data.model.User
import com.example.appfilmes.data.repository.UserRepository

class UserViewModel(
    private val repository: UserRepository = UserRepository()
) : ViewModel(){



    var users by mutableStateOf(repository.getUsers())

    fun addUser(user: User){
        repository.addUser(user)
        users = repository.getUsers()
    }

    fun removeUser(id: String){
        repository.removeUser(id)
        users = repository.getUsers()
    }

    fun updateUser(user: User){
        repository.updateUser(user)
    }

    fun validateUser(email: String, senha: String): User?{
        users.forEach {
                u -> if (u.email == email && u.senha == senha) return u
        }
        return null
    }
}