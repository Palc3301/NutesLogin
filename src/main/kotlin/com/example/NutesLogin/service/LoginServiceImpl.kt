package com.example.NutesLogin.service

import com.example.NutesLogin.model.Login
import com.example.NutesLogin.repository.LoginRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class LoginServiceImpl(private val repository: LoginRepository) : LoginService {
    override fun create(login: Login): Login {
        return repository.save(login)
    }

    override fun getAll(): List<Login> {
        return repository.findAll()
    }

    override fun getByID(id: String): Optional<Login> {
        return repository.findById(id)
    }

    override fun update(id: String, login: Login): Optional<Login> {
        val optional = getByID(id)
        if (optional.isEmpty) Optional.empty<Login>()

        return optional.map {
            val loginToUpdate = it.copy(
                name = login.name,
                password = login.password
            )
            repository.save(loginToUpdate)
        }
    }

    override fun delete(id: String) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow {throw RuntimeException("Id not found $id")}
    }
}