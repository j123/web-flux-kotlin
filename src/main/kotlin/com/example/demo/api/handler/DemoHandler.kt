package com.example.demo.api.handler

import org.springframework.http.MediaType.*
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class DemoHandler {
    fun getDemo(req: ServerRequest): Mono<ServerResponse> {
        return ok()
                .contentType(APPLICATION_JSON_UTF8)
                .body(Flux.just("{\"message\":\"hello kotlin\"}"), String::class.java)
    }
}