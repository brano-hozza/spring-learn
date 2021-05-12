package com.example.blog.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    var username: String,
    var firstname: String,
    var lastname: String,
    var password: String,
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null)

data class NewUser (
    val username: String,
    val password: String
)