package br.com.org.gameslist.main

import br.com.org.gameslist.model.RentPeriod
import br.com.org.gameslist.services.GameApi
import java.time.LocalDate

fun main() {
    val consume = GameApi()
    val playerList = consume.playersFindJson()
    val gameList = consume.gamesFindJson()

    val playerCaroline = playerList.get(3)
    val gameResidentVillage = gameList.get(10)
    val gameSpider = gameList.get(13)
    val gameTLOU = gameList.get(2)

    println(playerCaroline)
    println(gameResidentVillage)

    val period1 = RentPeriod(LocalDate.now(), LocalDate.now().plusDays(7))
    val period2 = RentPeriod(LocalDate.now(), LocalDate.now().plusDays(3))
    val period3 = RentPeriod(LocalDate.now(), LocalDate.now().plusDays(10))

    playerCaroline.gameRent(gameResidentVillage, period1)
    playerCaroline.gameRent(gameSpider, period2)
    playerCaroline.gameRent(gameTLOU, period3)

    println(playerCaroline.rentedGames)
}