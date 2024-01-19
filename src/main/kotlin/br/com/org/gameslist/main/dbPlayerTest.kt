package br.com.org.gameslist.main

import br.com.org.gameslist.data.Database
import br.com.org.gameslist.data.plan.PlansDAO
import br.com.org.gameslist.data.player.PlayerDAO
import br.com.org.gameslist.model.Player

fun main(){
    val player = Player("Fulano", "foo@email.com", "25/02/1995", "bas")

    val manager = Database.getEntityManager()
    val playerDAO = PlayerDAO(manager)
    val plansDAO = PlansDAO(manager)

    player.plan =  plansDAO.recoverById(3)

    playerDAO.add(player)

    val playerList = playerDAO.getList()
    println(playerList)

    manager.close()
}
