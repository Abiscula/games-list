package br.com.org.gameslist.data.player

import br.com.org.gameslist.data.DAO
import br.com.org.gameslist.model.Player
import javax.persistence.EntityManager

class PlayerDAO(private val manager: EntityManager): DAO<Player>() {

    override fun getList(): List<Player> {
        val query = manager.createQuery("FROM PlayerEntity", PlayerEntity::class.java)
        return query.resultList.map { entity -> Player(entity.name, entity.email, entity.birthDate,
            entity.user, entity.id) }
    }

    override fun add(obj: Player) {
        val entity = PlayerEntity(obj.name, obj.email, obj.birthDate, obj.user)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

}