package br.com.org.gameslist.main

import br.com.org.gameslist.services.GameApi

fun main() {
    val consume = GameApi()
    val playerList = consume.playersFindJson()
    val gameList = consume.gamesFindJson()

    val playerCaroline = playerList.get(3)
    val gameResidentVillage = gameList.get(10)

    println(playerCaroline)
    println(gameResidentVillage)

    val rent = playerCaroline.gameRent(gameResidentVillage)
    println(rent)
}