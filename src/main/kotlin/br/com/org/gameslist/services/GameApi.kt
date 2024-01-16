package br.com.org.gameslist.services

import br.com.org.gameslist.model.Gamer
import br.com.org.gameslist.model.InfoGame
import br.com.org.gameslist.model.InfoGamerJson
import br.com.org.gameslist.utils.gamerCreate
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GameApi {

    fun gameFind(id: String): InfoGame {
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient();
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val myInfoGame = gson.fromJson(json, InfoGame::class.java)

        return myInfoGame
    }

    fun gamersFind(): List<Gamer> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient();
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val gamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val gamerList: List<InfoGamerJson> = gson.fromJson(json, gamerType)

        val convertGamerList = gamerList.map { infoGamerJson -> infoGamerJson.gamerCreate() }

        return convertGamerList
    }

}