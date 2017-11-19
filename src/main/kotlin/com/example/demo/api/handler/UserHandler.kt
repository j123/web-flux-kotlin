package com.example.demo.api.handler

import com.example.demo.domain.User
import org.springframework.http.MediaType.*
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.bodyToServerSentEvents
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.Instant

@Component
class UserHandler {

    private val users = Flux.just(
            User("一郎", "クレスコ", 20),
            User("二郎", "クレスコ", 30),
            User("三郎", "クレスコ", 40),
            User("四郎", "クレスコ", 50),
            User("五郎", "クレスコ", 60))

    private val streamingUsers = Flux
            .zip(Flux.interval(Duration.ofSeconds(1)), users.repeat())
            .map { it.t2 }

    fun findAll(req: ServerRequest): Mono<ServerResponse> {
        return ok()
                .contentType(APPLICATION_JSON_UTF8)
                .body(users, User::class.java)
    }

    fun streamOneSec(req: ServerRequest) = ok().bodyToServerSentEvents(streamingUsers)

}