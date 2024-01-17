package br.com.org.gameslist.main

import br.com.org.gameslist.model.RentPeriod
import br.com.org.gameslist.model.SignaturePlan
import br.com.org.gameslist.services.GameApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consume = GameApi()
    val playerList = consume.playersFindJson()
    val gameList = consume.gamesFindJson()

    val gameResidentVillage = gameList.get(10)
    val gameSpider = gameList.get(13)
    val gameTLOU = gameList.get(2)
    val gameDandara = gameList.get(5)
    val gameAssassins = gameList.get(4)
    val gameCyber = gameList.get(6)
    val gameGod = gameList.get(7)
    val gameSkyrim = gameList.get(18)

    val period1 = RentPeriod(LocalDate.now(), LocalDate.now().plusDays(7))
    val period2 = RentPeriod(LocalDate.now(), LocalDate.now().plusDays(3))
    val period3 = RentPeriod(LocalDate.now(), LocalDate.now().plusDays(10))

    val playerCamila = playerList.get(5)
    playerCamila.plan = SignaturePlan("SILVER", 9.90, 3, 0.15)
    playerCamila.gameRent(gameResidentVillage, period1)
    playerCamila.gameRent(gameSpider, period2)
    playerCamila.gameRent(gameTLOU, period3)
    playerCamila.gameRent(gameTLOU, period3)

    playerCamila.recommend(7)
    playerCamila.recommend(10)
    playerCamila.recommend(8)

    playerCamila.gameRent(gameResidentVillage, period1)

    playerCamila.recommendGame(gameResidentVillage, 7)
    playerCamila.recommendGame(gameTLOU, 10)
    playerCamila.recommendGame(gameAssassins, 8)
    playerCamila.recommendGame(gameCyber, 7)
    playerCamila.recommendGame(gameGod, 10)
    playerCamila.recommendGame(gameDandara, 8)
    playerCamila.recommendGame(gameSkyrim, 8)


    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialize = gson.toJson(playerCamila.recommendedGamesList)

    val file = File("recomendedGames#${playerCamila.name}.json")
    file.writeText(serialize)
}