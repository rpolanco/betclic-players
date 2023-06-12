package players.betclic.com.application

import players.betclic.com.application.model.AddPlayerRequest
import players.betclic.com.application.model.PlayerApi
import players.betclic.com.core.Player
import players.betclic.com.core.PlayerWithRanking

fun Player.toApi() = PlayerApi(pseudo, pointsNumber, Int.MAX_VALUE)
fun PlayerWithRanking.toApi() = PlayerApi(player.pseudo, player.pointsNumber, ranking)
fun PlayerApi.toDomain() = Player(pseudo, pointsNumber ?: 0)

fun AddPlayerRequest.toDomain() = Player(pseudo)
