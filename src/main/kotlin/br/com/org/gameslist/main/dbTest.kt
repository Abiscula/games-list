package br.com.org.gameslist.main

import br.com.org.gameslist.data.Database
import br.com.org.gameslist.data.game.GamesDAO
import br.com.org.gameslist.model.Game
import java.math.BigDecimal

fun main() {

    val game = Game("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", BigDecimal(5.99) ,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val game2 = Game("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", BigDecimal(9.99),"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    val manager = Database.getEntityManager()
    val gameDAO = GamesDAO(manager)

    gameDAO.add(game2)

    val specificGame = gameDAO.recoverById(4)
    println(specificGame)

    gameDAO.delete(4)

    val gamesList: List<Game> = gameDAO.getList()
    println(gamesList)

//    val player = Player("Victor", "victorabiscula@live.com", "25/02/1995", "Abiscula")
//    val playerDAO = PlayerDAO(manager)
//
//    playerDAO.add(player)
//
//    val playerList = playerDAO.getList()
//    println(playerList)

    manager.close()
}

