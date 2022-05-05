package web

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import service.PropertyService

fun Route.property(propertyService: PropertyService) {

    route("/properties") {

        get {
            call.respond(propertyService.getAll())
        }

//        get("/{id}") {
//            val id = call.parameters["id"]?.toInt() ?: throw IllegalStateException("Must provide id")
//            val widget = propertyService.getWidget(id)
//            if (widget == null) call.respond(HttpStatusCode.NotFound)
//            else call.respond(widget)
//        }

    }
}
