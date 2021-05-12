package com.glatoo.blog.repositories;

import com.glatoo.blog.models.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
        fun findBySlug(slug: String): Article?
        fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}
