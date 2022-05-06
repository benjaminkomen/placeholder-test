package web

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import service.PropertyService

fun Route.property(propertyService: PropertyService) {

    route("/properties") {

        get {
            if (call.request.queryParameters["id"]?.isNotEmpty() == true) {
                val propertyId = call.request.queryParameters["id"]?.toInt() ?: throw IllegalStateException("Could not extract param property id")
                propertyService.getProperty(propertyId)
                    ?.let { call.respond(it) }
                    ?: call.respond(HttpStatusCode.NotFound)
            } else {
                call.respond(propertyService.getAll())
            }
        }

        get("/{id}") {
            val propertyId = call.parameters["id"]?.toInt() ?: throw IllegalStateException("Must provide property id")
            propertyService.getProperty(propertyId)
                ?.let { call.respond(it) }
                ?: call.respond(HttpStatusCode.NotFound)
        }
    }
}
