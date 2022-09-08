package com.example.NutesLogin.controller

import com.example.NutesLogin.model.Login
import com.example.NutesLogin.repository.LoginRepository
import com.example.NutesLogin.service.LoginService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/logins")
class LoginController(private val service: LoginService ,val repository: LoginRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody login: Login): ResponseEntity<Login> {
        val loginSave = service.create(login)
        return ResponseEntity.ok(loginSave)
    }

    @GetMapping
    fun getAll(): List<Login> = service.getAll()

    @GetMapping("{id}")
    fun getById(@PathVariable id: String) : ResponseEntity<Login> =
        service.getByID(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("{id}")
    fun update(@PathVariable id: String, @RequestBody login: Login) : ResponseEntity<Login> =
        service.update(id, login).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: String) : ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }
}

