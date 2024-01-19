package br.com.org.gameslist.data.plan

import br.com.org.gameslist.data.DAO
import br.com.org.gameslist.model.Plan
import br.com.org.gameslist.model.SeparatePlan
import br.com.org.gameslist.model.SignaturePlan
import javax.persistence.EntityManager

class PlansDAO(manager: EntityManager): DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {

    override fun toEntity(obj: Plan): PlanEntity {
        return  if (obj is SignaturePlan) {
            SignaturePlanEntity(obj.type, obj.monthlyPayment, obj.includedGames, obj.reputationDiscount, obj.id)
        } else {
            SeparetedPlanEntity(obj.type, obj.id)
        }
    }

    override fun toModel(entity: PlanEntity): Plan {
        return if (entity is SignaturePlanEntity) {
            SignaturePlan(entity.type, entity.monthlyPayment, entity.includedGames, entity.reputationDiscount, entity.id)
        } else {
            SeparatePlan(entity.type, entity.id)
        }
    }

}