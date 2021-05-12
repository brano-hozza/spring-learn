package com.glatoo.blog

import com.glatoo.blog.models.Article
import com.glatoo.blog.models.User
import com.glatoo.blog.repositories.ArticleRepository
import com.glatoo.blog.repositories.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository
) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val user1 = User("test", "Juergen", "Hoeller","pass")
        entityManager.persist(user1)
        val article = Article("Spring Framework 5.0 goes GA", "Dear Spring community ...", "Lorem ipsum", user1)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val user1 = User("test", "Juergen", "Hoeller","pass")
        entityManager.persist(user1)
        entityManager.flush()
        val user = userRepository.findByUsername(user1.username)
        assertThat(user).isEqualTo(user1)
    }
}