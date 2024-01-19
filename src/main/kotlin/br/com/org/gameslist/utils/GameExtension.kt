package br.com.org.gameslist.utils

import br.com.org.gameslist.data.game.GameEntity
import br.com.org.gameslist.model.Game
import br.com.org.gameslist.model.InfoGameJson

fun InfoGameJson.gameCreate(): Game {
    return Game(this.titulo, this.capa, this.preco, this.descricao)
}

fun Game.toEntity(): GameEntity {
    return GameEntity(this.title, this.cover, this.price, this.description, this.id)
}

fun GameEntity.toModel(): Game {
    return Game(this.title, this.cover, this.price, this.description, this.id)
}