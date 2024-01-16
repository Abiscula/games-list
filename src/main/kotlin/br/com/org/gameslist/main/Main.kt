package br.com.org.gameslist.main
import br.com.org.gameslist.model.Game
import br.com.org.gameslist.model.Gamer
import br.com.org.gameslist.services.GameApi
import getAge
import java.util.*

fun main() {

    val read = Scanner(System.`in`)
    val gamer = Gamer.createGamer(read)
    println("Cadastro concluído")
    println(gamer)
    println("Idade do gamer " + gamer.birthDate?.getAge())

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

            gamer.gamesSearched.add(myGame)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resp = read.nextLine()

    } while (resp.equals("s", true))

    print(gamer.gamesSearched)

    println("\nJogos por titulo")
    gamer.gamesSearched.sortBy {
        it?.title
    }

    gamer.gamesSearched.forEach {
        println("Titulo: " + it?.title)
    }

    val filteredGames = gamer.gamesSearched.filter {
        it?.title?.contains("batman", true) ?: false
    }

    println("\nJogos filtrados" + filteredGames)
}