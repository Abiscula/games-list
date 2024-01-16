package br.com.org.gameslist.services

import br.com.org.gameslist.model.*
import br.com.org.gameslist.utils.gameCreate
import br.com.org.gameslist.utils.playerCreate
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GameApi {

    private fun getApiData(address: String): String? {
        val client: HttpClient = HttpClient.newHttpClient();
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }


    fun gameFind(id: String): InfoGame {
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = getApiData(address)
        val gson = Gson()

        val myInfoGame = gson.fromJson(json, InfoGame::class.java)

        return myInfoGame
    }

    fun playersFindJson(): List<Player> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = getApiData(address)
        val gson = Gson()

        val playerType = object : TypeToken<List<InfoPlayerJson>>() {}.type
        val playerList: List<InfoPlayerJson> = gson.fromJson(json, playerType)

        val convertPlayerList = playerList.map { playerJson -> playerJson.playerCreate() }

        return convertPlayerList
    }

    fun gamesFindJson(): List<Game> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = getApiData(address)
        val gson = Gson()

        val gameType = object : TypeToken<List<InfoGameJson>>() {}.type
        val gameList: List<InfoGameJson> = gson.fromJson(json, gameType)

        val convertGameList = gameList.map { gameJson -> gameJson.gameCreate() }

        return convertGameList
    }

}