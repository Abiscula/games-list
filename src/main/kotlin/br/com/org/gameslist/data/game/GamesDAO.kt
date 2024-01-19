package br.com.org.gameslist.data.game

import br.com.org.gameslist.data.DAO
import br.com.org.gameslist.model.Game
import javax.persistence.EntityManager

class GamesDAO(manager: EntityManager): DAO<Game, GameEntity>(manager, GameEntity::class.java) {

    override fun toEntity(obj: Game): GameEntity {
        return GameEntity(obj.title, obj.cover, obj.price, obj.description)
    }

    override fun toModel(entity: GameEntity): Game {
        return Game(entity.title, entity.cover, entity.price, entity.description, entity.id)
    }

}