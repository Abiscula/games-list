package br.com.org.gameslist.data.game

import br.com.org.gameslist.data.DAO
import br.com.org.gameslist.model.Game
import br.com.org.gameslist.utils.toEntity
import br.com.org.gameslist.utils.toModel
import javax.persistence.EntityManager

class GamesDAO(manager: EntityManager): DAO<Game, GameEntity>(manager, GameEntity::class.java) {

    override fun toEntity(obj: Game): GameEntity {
        return obj.toEntity()
    }

    override fun toModel(entity: GameEntity): Game {
        return entity.toModel()
    }

}