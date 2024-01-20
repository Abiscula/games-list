package br.com.org.gameslist.utils

import br.com.org.gameslist.data.player.PlayerEntity
import br.com.org.gameslist.model.InfoPlayerJson
import br.com.org.gameslist.model.Player

fun InfoPlayerJson.playerCreate(): Player {
    return Player(this.nome, this.email, this.dataNascimento, this.usuario)
}

fun Player.toEntity(): PlayerEntity {
    return PlayerEntity(this.name, this.email, this.birthDate, this.user, this.id, this.plan.toEntity())
}

fun PlayerEntity.toModel(): Player {
    return Player(this.name, this.email, this.birthDate, this.user, this.id)
}