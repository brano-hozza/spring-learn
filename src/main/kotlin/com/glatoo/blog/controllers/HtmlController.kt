package com.glatoo.blog.controllers

import com.glatoo.blog.repositories.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Controller
class HtmlController(private val repository: ArticleRepository) {
    @GetMapping("/")
    fun login(model: Model): String{
        model["title"] = "Login"
        return "home"
    }

    @GetMapping("/article/{slug}")
    fun article(@PathVariable slug: String, model: Model): String {
        val article = repository
            .findBySlug(slug)
            ?.render()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")
        model["title"] = article.title
        model["article"] = article
        return "article"
    }




}