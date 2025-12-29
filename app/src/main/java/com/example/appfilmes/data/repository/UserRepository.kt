package com.example.appfilmes.data.repository

import com.example.appfilmes.data.model.User

class UserRepository {
    private val userList = mutableListOf<User>()

    fun getUsers(): List<User> = userList

    fun addUser(user: User){
        userList.add(user)
    }

    fun removeUser(id: String) {
        userList.removeAll { it.id == id }
    }


    fun updateUser(user: User) {
        val index = userList.indexOfFirst { it.id == user.id }
        if (index != -1) {
            userList[index] = user
        }
    }

    fun getUserById(id: String): User? {
        userList.forEach { u->
            if (u.id == id) return u
        }
        return null
    }


}