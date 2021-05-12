package com.glatoo.blog.controllers

import com.glatoo.blog.models.NewUser
import com.glatoo.blog.models.User
import com.glatoo.blog.repositories.UserRepository
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/user")
class UserController(private val userRepository: UserRepository) {
    @PostMapping("/register")
    fun register(@JsonFormat userReq: NewUser, model: Model): String{
        val newUser = User(userReq.username, userReq.password)
        userRepository.save(newUser)
        model["title"] = "Profile"
        model["user"] = newUser.render()
        return "profile"
    }
    @PostMapping("/login")
    fun login(@JsonFormat user: NewUser, model: Model): String{
        model["title"] = "Profile"
        val userFound: User? = userRepository.findByUsername(user.username)
        if (userFound?.password == user.password) {
            model["user"] = userFound.render()
            return "profile"
        }
        return "404"
    }
}