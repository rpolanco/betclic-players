package players.betclic.com.application

import players.betclic.com.application.model.AddPlayerRequest
import players.betclic.com.application.model.PlayerApi
import players.betclic.com.core.Player
import players.betclic.com.core.PlayerWithRanking

fun PlayerWithRanking.toApi() = PlayerApi(player.pseudo, player.pointsNumber, ranking)

fun AddPlayerRequest.toDomain() = Player(pseudo)
