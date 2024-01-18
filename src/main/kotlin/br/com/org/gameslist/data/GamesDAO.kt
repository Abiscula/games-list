package br.com.org.gameslist.data

import br.com.org.gameslist.model.Game
import java.math.BigDecimal

class GamesDAO {

    fun getGames(): List<Game> {
        val connection = Database.getConection()
        val gamesList = mutableListOf<Game>()

        if (connection != null) {
            try {
                val statement = connection.createStatement()
                val result = statement.executeQuery("SELECT * FROM jogos")

                while (result.next()) {
                    val id = result.getInt("id")
                    val title = result.getString("titulo")
                    val cover = result.getString("capa")
                    val description = result.getString("descricao")
                    val price = result.getDouble("preco")

                    val game = Game(title, cover, BigDecimal(price), description, id)
                    gamesList.add(game)
                }
                statement.close()
            } finally {
                connection.close()
            }
        }
        return gamesList
    }

    fun addGame(game: Game) {
        val connection = Database.getConection()
        val insert = "INSERT INTO jogos (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"

        if(connection != null) {
            try {
                val statement = connection.prepareStatement(insert)
                statement.setString(1, game.title)
                statement.setString(2, game.cover)
                statement.setBigDecimal(3, game.price)
                statement.setString(4, game.description)

                statement.executeUpdate()
                statement.close()
            } finally {
                connection.close()
            }
        }
    }
}