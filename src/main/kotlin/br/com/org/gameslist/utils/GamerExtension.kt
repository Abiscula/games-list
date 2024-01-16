package br.com.org.gameslist.utils

import br.com.org.gameslist.model.Gamer
import br.com.org.gameslist.model.InfoGamerJson

fun InfoGamerJson.gamerCreate(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}