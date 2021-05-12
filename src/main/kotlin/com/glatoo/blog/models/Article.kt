package com.glatoo.blog.models

import com.example.blog.format
import com.example.blog.toSlug
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null)
{
    fun render() = RenderedArticle(
        slug,
        title,
        headline,
        content,
        author,
        addedAt.format()
    )
}

data class NewArticle (
    val title: String,
    val slug: String = title.toSlug(),
)

data class RenderedArticle(
    val slug: String,
    val title: String,
    val headline: String,
    val content: String,
    val author: User,
    val addedAt: String)
