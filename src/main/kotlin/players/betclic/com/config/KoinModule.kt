package players.betclic.com.config

import org.koin.dsl.module
import players.betclic.com.core.PlayerRepository
import players.betclic.com.core.PlayerServiceImpl
import players.betclic.com.infrastructure.MongoPlayerRepository

val koinModule = module  {
    single<PlayerRepository> { MongoPlayerRepository() }
    single { PlayerServiceImpl(get()) }

}