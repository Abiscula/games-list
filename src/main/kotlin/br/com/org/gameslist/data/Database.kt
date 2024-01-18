package br.com.org.gameslist.data

import br.com.org.gameslist.model.Game
import java.math.BigDecimal
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/*
* O object é utilizado para criar objetos singleton.
* Um objeto singleton é um instância única de uma classe, ou seja, apenas uma única instância dessa classe é
* criada durante o ciclo de vida do programa.
*/
object Database {
    fun getConection(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/gameslistdb", "root", "root")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    fun getGames(): List<Game> {
        val connection = this.getConection()
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

                    val game = Game(title, cover, description, BigDecimal(price), id)
                    gamesList.add(game)
                }

                statement.close()
            } finally {
                connection.close()
            }
        }
        return gamesList
    }
}