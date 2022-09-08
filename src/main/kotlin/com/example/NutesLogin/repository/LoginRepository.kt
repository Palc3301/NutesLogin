package com.example.NutesLogin.repository

import com.example.NutesLogin.model.Login
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface LoginRepository: MongoRepository<Login, String> {
    //fun findById(id: Id): Optional<Login>
    //public List<User> findAll();
}