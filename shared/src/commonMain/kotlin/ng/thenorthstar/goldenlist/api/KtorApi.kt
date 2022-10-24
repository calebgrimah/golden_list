package ng.thenorthstar.goldenlist.api

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import ng.thenorthstar.goldenlist.util.baseUrl


internal abstract class KtorApi {
    @OptIn(ExperimentalSerializationApi::class)
    private val jsonConfiguration = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
        isLenient = true
        explicitNulls = false
    }

    val client = HttpClient {
        install(ContentNegotiation) {
            json(jsonConfiguration)
            register(ContentType.Application.Json, KotlinxSerializationConverter(jsonConfiguration))
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v("[Napier Http Client:]", null, message)
                }
            }
            level = LogLevel.HEADERS
        }.also { Napier.base(DebugAntilog()) }
    }

    fun HttpRequestBuilder.apiUrl(path: String) {
        url {
            accept(ContentType.Application.Json)
            contentType(ContentType.Application.Json)
            takeFrom(baseUrl)
            path(path)
            expectSuccess = true
        }
    }

    fun HttpRequestBuilder.apiPostUrl(path: String, requestBody: Any) {
        url {
            contentType(ContentType.Application.Json)
            takeFrom(baseUrl)
            path(path)
            setBody(requestBody)
        }
    }
}
