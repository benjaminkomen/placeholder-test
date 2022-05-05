package web

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.index() {

    val indexPage = javaClass.getResource("/index.html")?.readText() ?: "could not get index.html"

    get("/") {
        call.respondText(indexPage, ContentType.Text.Html)
    }
}
