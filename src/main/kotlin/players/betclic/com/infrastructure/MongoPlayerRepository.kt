package players.betclic.com.infrastructure

import org.litote.kmongo.*
import players.betclic.com.core.Player
import players.betclic.com.core.PlayerRepository

class MongoPlayerRepository : PlayerRepository {

    private val client = KMongo.createClient()
    private val database = client.getDatabase("player")
    private val playerCollection = database.getCollection("player", Player::class.java)

    override fun add(player: Player) {
        playerCollection.insertOne(player)
    }

    override fun setPointsNumber(pseudo: String, pointsNumber: Int) {
        playerCollection.updateOne(Player::pseudo eq pseudo, set(Player::pointsNumber setTo pointsNumber))
    }

    override fun findByPseudo(pseudo: String): Player? {
        return playerCollection.findOne(Player::pseudo eq pseudo)
    }

    override fun findAll(): List<Player> {
        return playerCollection.find().toList()
    }

    override fun removeAll() {
        playerCollection.deleteMany(Player::pseudo exists true)
    }
}