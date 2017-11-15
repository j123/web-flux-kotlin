package com.example.demo.router

import com.example.demo.handler.DemoHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.*
import org.springframework.web.reactive.function.server.router

@Configuration
class Router(private val handler: DemoHandler) {

    @Bean
    fun apiRouter() = router {
        (accept(APPLICATION_JSON_UTF8)).nest {
            GET("/", handler::getDemo)
        }

    }

}