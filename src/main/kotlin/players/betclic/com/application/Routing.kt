package players.betclic.com.application

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import players.betclic.com.application.model.AddPlayerRequest
import players.betclic.com.application.model.SetPointsNumberRequest
import players.betclic.com.core.PlayerServiceImpl

fun Application.configureRouting() {

    val playerService by inject<PlayerServiceImpl>()

    routing {
        post("/players") {
            val player = call.receive<AddPlayerRequest>()

            call.respond(HttpStatusCode.Created, playerService.add(player.toDomain()))
        }

        put("/players/{pseudo}") {
            val pseudo = call.parameters["pseudo"]!!
            val pointsNumber = call.receive<SetPointsNumberRequest>().pointsNumber

            call.respond(HttpStatusCode.Created, playerService.setPointsNumber(pseudo, pointsNumber))
        }

        get("/players/{pseudo}") {
            val playerWithRanking = playerService.getByPseudo(call.parameters["pseudo"]!!)
            call.respond(HttpStatusCode.OK, playerWithRanking.toApi())
        }

        get("/players") {
            val players = playerService.findAll().map { it.toApi() }
            call.respond(HttpStatusCode.OK, players)
        }

        delete("/players") {
            call.respond(HttpStatusCode.OK, playerService.removeAll())
        }
    }
}
