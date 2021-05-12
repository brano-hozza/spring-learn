package com.glatoo.blog.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    var username: String,
    var password: String,
    var firstname: String? = "Not set",
    var lastname: String? = "Not set",
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null){
    fun render() = RenderedUser(username, firstname, lastname)
}

data class NewUser (
    val username: String,
    val password: String
)

data class RenderedUser(
    var username: String,
    var firstname: String? = "Not set",
    var lastname: String? = "Not set"
)