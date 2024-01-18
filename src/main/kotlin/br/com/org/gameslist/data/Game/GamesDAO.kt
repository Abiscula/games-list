package br.com.org.gameslist.data.Game

import br.com.org.gameslist.model.Game
import javax.persistence.EntityManager

class GamesDAO(val manager: EntityManager) {

    fun getGames(): List<Game> {
        val query = manager.createQuery("FROM GameEntity", GameEntity::class.java)
        return query.resultList.map { entity -> Game(entity.title, entity.cover,
            entity.price, entity.description, entity.id) }
    }

    fun addGame(game: Game) {
        val entity = GameEntity(game.title, game.cover, game.price, game.description)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

}