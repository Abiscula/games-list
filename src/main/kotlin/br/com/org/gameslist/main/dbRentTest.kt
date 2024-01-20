package br.com.org.gameslist.main

import br.com.org.gameslist.data.Database
import br.com.org.gameslist.data.game.GamesDAO
import br.com.org.gameslist.data.player.PlayerDAO
import br.com.org.gameslist.data.rent.RentDAO
import br.com.org.gameslist.model.RentPeriod

fun main() {

    val manager = Database.getEntityManager()
    val gameDAO = GamesDAO(manager)
    val playerDAO = PlayerDAO(manager)
    val rentDAO = RentDAO(manager)

    val player = playerDAO.recoverById(30)
    val game = gameDAO.recoverById(3)

    val rent = player.gameRent(game, RentPeriod())

    rentDAO.add(rent)

    val rentList = rentDAO.getList()
    println(rentList)

    manager.close()
}