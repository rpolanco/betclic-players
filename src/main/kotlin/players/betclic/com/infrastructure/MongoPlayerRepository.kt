package players.betclic.com.infrastructure

import players.betclic.com.core.Player
import players.betclic.com.core.PlayerRepository

class MongoPlayerRepository : PlayerRepository {
    private val _players = arrayListOf(
        Player("toto", 11),
        Player("titi", 10)
    )

    override fun add(player: Player) {
        _players.add(player)
    }

    override fun setPointsNumber(pseudo: String, pointsNumber: Int) {
        val player = findByPseudo(pseudo)

        player?.let {
            val updatedPlayer = it.copy(pointsNumber = pointsNumber)
            _players.remove(it)
            _players.add(updatedPlayer)
        }
    }

    override fun findByPseudo(pseudo: String): Player? {
        return _players.firstOrNull { it.pseudo == pseudo }
    }

    override fun findAll(): List<Player> {
        return _players
    }

    override fun removeAll() {
        _players.clear()
    }
}