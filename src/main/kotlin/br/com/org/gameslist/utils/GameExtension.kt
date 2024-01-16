package br.com.org.gameslist.utils

import br.com.org.gameslist.model.Game
import br.com.org.gameslist.model.InfoGameJson

fun InfoGameJson.gameCreate(): Game {
    return Game(this.titulo, this.capa, this.descricao, this.preco)
}