package br.com.org.gameslist.data.player

import br.com.org.gameslist.data.DAO
import br.com.org.gameslist.model.Player
import javax.persistence.EntityManager

class PlayerDAO(manager: EntityManager): DAO<Player, PlayerEntity>(manager, PlayerEntity::class.java) {
    override fun toEntity(obj: Player): PlayerEntity {
        return PlayerEntity(obj.name, obj.email, obj.birthDate, obj.user)
    }

    override fun toModel(entity: PlayerEntity): Player {
        return Player(entity.name, entity.email, entity.birthDate, entity.user, entity.id)
    }


}