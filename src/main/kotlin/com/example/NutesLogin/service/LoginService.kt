package com.example.NutesLogin.service

import com.example.NutesLogin.model.Login
import java.util.*

interface LoginService {

    fun create(login: Login) : Login

    fun getAll() : List<Login>

    fun getByID(id: String) : Optional<Login>

    fun update(id: String, login: Login) : Optional<Login>

    fun delete(id: String)
}