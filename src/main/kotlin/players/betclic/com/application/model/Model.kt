package players.betclic.com.application.model

// API requests
data class AddPlayerRequest(val pseudo: String)
data class SetPointsNumberRequest(val pointsNumber: Int)

// API responses
data class PlayerApi(val pseudo: String, val pointsNumber: Int?, val ranking: Int?)