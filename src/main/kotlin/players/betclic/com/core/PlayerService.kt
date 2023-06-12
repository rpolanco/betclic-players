package players.betclic.com.core

class PlayerServiceImpl(private val playerRepository: PlayerRepository) {

    fun add(player: Player): Player {
        // checking some business rules
        checkPointsNumber(player.pointsNumber)
        playerRepository.findByPseudo(player.pseudo)?.also {
            throw AlreadyExistException("Player ${player.pseudo} already exists")
        }

        playerRepository.add(player)
        return player
    }

    fun setPointsNumber(pseudo: String, pointsNumber: Int) {
        // checking some business rules
        checkPointsNumber(pointsNumber)
        playerRepository.findByPseudo(pseudo) ?: throw NotFoundException("Player $pseudo not found")

        playerRepository.setPointsNumber(pseudo, pointsNumber)
    }

    private fun checkPointsNumber(pointsNumber: Int) {
        pointsNumber < 0 && throw IllegalArgumentException("Points number must be positive")
    }

    fun getByPseudo(pseudo: String): PlayerWithRanking {
        return findAll().firstOrNull { it.player.pseudo == pseudo} ?: throw NotFoundException("Player $pseudo not found")
    }

    fun findAll(): List<PlayerWithRanking> {
        return playerRepository.findAll().sortedByDescending { it.pointsNumber }
            .mapIndexed { index, player ->  PlayerWithRanking(player, index + 1) }
    }

    fun removeAll() {
        playerRepository.removeAll()
    }
}

data class PlayerWithRanking(val player: Player, val ranking: Int)

data class Player(val pseudo: String, val pointsNumber: Int) {
    constructor(pseudo: String) : this(pseudo, 0)
}

