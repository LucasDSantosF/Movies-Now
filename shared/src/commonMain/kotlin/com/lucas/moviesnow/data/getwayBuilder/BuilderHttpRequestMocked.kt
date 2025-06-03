package com.lucas.moviesnow.data.getwayBuilder

import com.apollographql.apollo.network.http.HttpEngine
import com.apollographql.apollo.api.http.HttpRequest
import com.apollographql.apollo.api.http.HttpResponse
import okio.Buffer
import okio.ByteString.Companion.encodeUtf8


class BuilderHttpRequestMocked(private val jsonResponse: String) : HttpEngine {
    override suspend fun execute(request: HttpRequest): HttpResponse {
        val buffer = Buffer()
        buffer.write(jsonResponse.encodeUtf8())

        return HttpResponse.Builder(200)
            .body(buffer)
            .build()
    }
}