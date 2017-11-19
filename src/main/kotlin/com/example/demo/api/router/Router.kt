package com.example.demo.api.router

import com.example.demo.api.handler.DemoHandler
import com.example.demo.api.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.*
import org.springframework.web.reactive.function.server.router

@Configuration
class Router(private val demoHandler: DemoHandler, private val userHandler: UserHandler) {

    @Bean
    fun apiRouter() = router {
        accept(APPLICATION_JSON_UTF8).nest {
            GET("/", demoHandler::getDemo)
            GET("/users", userHandler::findAll)

        }
        accept(TEXT_EVENT_STREAM).nest {
            GET("/users", userHandler::streamOneSec)
        }
    }
}
