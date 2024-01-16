package br.com.org.gameslist.utils

import br.com.org.gameslist.model.InfoPlayerJson
import br.com.org.gameslist.model.Player

fun InfoPlayerJson.playerCreate(): Player {
    return Player(this.nome, this.email, this.dataNascimento, this.usuario)
}