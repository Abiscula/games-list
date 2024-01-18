package br.com.org.gameslist.data

import br.com.org.gameslist.model.Game

class GamesDAO {

    fun getGames(): List<Game> {
        val manager = Database.getEntityManager()
        try {
            val query = manager.createQuery("FROM Game", Game::class.java)
            return query.resultList
        } finally {
            manager.close()
        }
    }

}