package com.glatoo.blog.repositories

import com.glatoo.blog.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String): User?
}