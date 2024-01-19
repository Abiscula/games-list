package br.com.org.gameslist.utils

import br.com.org.gameslist.data.plan.PlanEntity
import br.com.org.gameslist.data.plan.SeparetedPlanEntity
import br.com.org.gameslist.data.plan.SignaturePlanEntity
import br.com.org.gameslist.model.Plan
import br.com.org.gameslist.model.SeparatePlan
import br.com.org.gameslist.model.SignaturePlan

fun Plan.toEntity(): PlanEntity {
    return  if (this is SignaturePlan) {
        SignaturePlanEntity(this.type, this.monthlyPayment, this.includedGames, this.reputationDiscount, this.id)
    } else {
        SeparetedPlanEntity(this.type, this.id)
    }
}

fun PlanEntity.toModel(): Plan {
    return if (this is SignaturePlanEntity) {
        SignaturePlan(this.type, this.monthlyPayment, this.includedGames, this.reputationDiscount, this.id)
    } else {
        SeparatePlan(this.type, this.id)
    }
}