package br.com.org.gameslist.data.Player

import br.com.org.gameslist.model.Player
import javax.persistence.EntityManager

class PlayerDAO(val manager: EntityManager) {

    fun getPlayer(): List<Player> {
        val query = manager.createQuery("From PlayerEntity", PlayerEntity::class.java)
        return query.resultList.map { entity -> Player(entity.name, entity.email, entity.birthDate,
            entity.user, entity.id) }
    }

    fun addPlayer(player: Player) {
        val entity = PlayerEntity(player.name, player.email, player.birthDate, player.user)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

}