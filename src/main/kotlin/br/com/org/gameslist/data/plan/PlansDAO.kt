package br.com.org.gameslist.data.plan

import br.com.org.gameslist.data.DAO
import br.com.org.gameslist.model.Plan
import br.com.org.gameslist.utils.toEntity
import br.com.org.gameslist.utils.toModel
import javax.persistence.EntityManager

class PlansDAO(manager: EntityManager): DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {

    override fun toEntity(obj: Plan): PlanEntity {
        return obj.toEntity()
    }

    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()
    }

}