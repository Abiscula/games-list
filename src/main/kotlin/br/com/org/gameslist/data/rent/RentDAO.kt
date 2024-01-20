package br.com.org.gameslist.data.rent

import br.com.org.gameslist.data.DAO
import br.com.org.gameslist.model.Rent
import br.com.org.gameslist.utils.toEntity
import br.com.org.gameslist.utils.toModel
import javax.persistence.EntityManager

class RentDAO(manager: EntityManager): DAO<Rent, RentEntity>(manager, RentEntity::class.java) {

    override fun toEntity(obj: Rent): RentEntity {
        return RentEntity(obj.player.toEntity(), obj.game.toEntity(), obj.period)
            .apply {
                rentValue = obj.rentValue
                id = obj.id
            }
    }

    override fun toModel(entity: RentEntity): Rent {
        return Rent(entity.player.toModel(), entity.game.toModel(), entity.period)
            .apply { id = entity.id }
    }

}