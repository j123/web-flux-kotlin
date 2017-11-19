package com.example.demo.api.handler

import com.example.demo.domain.User
import org.springframework.http.MediaType.*
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Instant

@Component
class UserHandler {

    private val users = Flux.just(
            User("hoge", "hoge", 20, Instant.now()),
            User("fuga", "fuga", 30, Instant.now()),
            User("piyo", "piyo", 40, Instant.now()))

    fun findAll(req: ServerRequest): Mono<ServerResponse> {
        return ok()
                .contentType(APPLICATION_JSON_UTF8)
                .body(users, User::class.java)
    }

}