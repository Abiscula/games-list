package br.com.org.gameslist.data

import br.com.org.gameslist.model.Game

class GamesDAO {

    fun getGames(): List<Game> {
        val manager = Database.getEntityManager()
        try {
            val query = manager.createQuery("FROM GameEntity", GameEntity::class.java)
            return query.resultList.map { entity -> Game(entity.title, entity.cover,
                entity.price, entity.description, entity.id) }
        } finally {
            manager.close()
        }
    }

}