
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

fun main() {

    val read = Scanner(System.`in`)
    println("Digite um codigo de jogo para buscar")
    val search = read.nextLine()

    val address = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient();
    val request: HttpRequest = HttpRequest.newBuilder()
        .uri(URI.create(address))
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()

    val gson = Gson()

    var myGame:Game? = null

    val result = runCatching {
        val myInfoGame = gson.fromJson(json, InfoGame::class.java)
        myGame = Game(myInfoGame.info.title, myInfoGame.info.thumb)
    }

    result.onFailure {
        println("Jogo não encontrado. Tente outro id")
    }

    result.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val option = read.nextLine()
        if (option.equals("s", true)) {
            println("Insira a descrição do jogo:")
            val customDescription = read.nextLine();
            myGame?.description = customDescription
        } else {
            myGame?.description = myGame?.title
        }

        println(myGame)
    }

}