package players.betclic.com

import org.koin.ktor.plugin.Koin
import players.betclic.com.config.koinModule
import players.betclic.com.application.configureRouting
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    install(Koin) {
        modules(koinModule)
    }

    install(ContentNegotiation) {
        jackson {}
    }

    configureRouting()
}
