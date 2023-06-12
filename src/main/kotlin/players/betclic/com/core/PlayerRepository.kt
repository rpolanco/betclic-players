package players.betclic.com.core

interface PlayerRepository {

    fun add(player: Player)
    fun setPointsNumber(pseudo: String, pointsNumber: Int)
    fun findByPseudo(pseudo: String): Player?
    fun findAll(): List<Player>
    fun removeAll()

}