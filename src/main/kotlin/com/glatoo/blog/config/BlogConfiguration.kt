package com.glatoo.blog.config

import com.glatoo.blog.repositories.ArticleRepository
import com.glatoo.blog.repositories.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepository
    ) = ApplicationRunner {


    }
}