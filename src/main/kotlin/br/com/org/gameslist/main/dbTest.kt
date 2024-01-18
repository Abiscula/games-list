package br.com.org.gameslist.main

import br.com.org.gameslist.data.Database
import br.com.org.gameslist.data.Game.GamesDAO
import br.com.org.gameslist.model.Game
import java.math.BigDecimal

fun main() {

    val game = Game("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", BigDecimal(5.99) ,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val game2 = Game("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", BigDecimal(9.99),"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    val manager = Database.getEntityManager()
    val gameDAO = GamesDAO(manager)

    gameDAO.addGame(game2)

    val gamesList: List<Game> = gameDAO.getGames()
    println(gamesList)

    manager.close()
}

