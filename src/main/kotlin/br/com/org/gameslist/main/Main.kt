package br.com.org.gameslist.main
import br.com.org.gameslist.model.Game
import br.com.org.gameslist.model.Player
import br.com.org.gameslist.services.GameApi
import getAge
import java.util.*

fun main() {

    val read = Scanner(System.`in`)
    val player = Player.createPlayer(read)
    println("Cadastro concluído")
    println(player)
    println("Idade do gamer " + player.birthDate?.getAge())

    do {
        println("Digite um codigo de jogo para buscar")
        val search = read.nextLine()

        val apiFind = GameApi()
        val infoGame = apiFind.gameFind(search)

        var myGame: Game? = null

        val result = runCatching {
            myGame = Game(infoGame.info.title, infoGame.info.thumb)
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

            player.gamesSearched.add(myGame)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resp = read.nextLine()

    } while (resp.equals("s", true))

    print(player.gamesSearched)

    println("\nJogos por titulo")
    player.gamesSearched.sortBy {
        it?.title
    }

    player.gamesSearched.forEach {
        println("Titulo: " + it?.title)
    }

    val filteredGames = player.gamesSearched.filter {
        it?.title?.contains("batman", true) ?: false
    }

    println("\nJogos filtrados" + filteredGames)
}