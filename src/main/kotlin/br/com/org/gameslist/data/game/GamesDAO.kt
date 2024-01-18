package br.com.org.gameslist.data.game

import br.com.org.gameslist.data.DAO
import br.com.org.gameslist.model.Game
import javax.persistence.EntityManager

class GamesDAO(private val manager: EntityManager): DAO<Game>() {

    override fun getList(): List<Game> {
        val query = manager.createQuery("FROM GameEntity", GameEntity::class.java)
        return query.resultList.map { entity -> Game(entity.title, entity.cover,
            entity.price, entity.description, entity.id) }
    }

    override fun add(obj: Game) {
        val entity = GameEntity(obj.title, obj.cover, obj.price, obj.description)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

}