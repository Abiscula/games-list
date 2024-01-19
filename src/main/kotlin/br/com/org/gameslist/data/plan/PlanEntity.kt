package br.com.org.gameslist.data.plan

import javax.persistence.*

@Entity
@Table(name = "plans")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typePlan", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    val type: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0)

@Entity
@DiscriminatorValue("separeted")
class SeparetedPlanEntity(type: String = "Plano Avulso", id: Int = 0): PlanEntity(type, id)

@Entity
@DiscriminatorValue("signature")
class SignaturePlanEntity(
    type: String = "Plano Assinatura",
    val monthlyPayment: Double = 0.0,
    val includedGames: Int = 0,
    val reputationDiscount: Double = 0.0,
    id: Int = 0): PlanEntity(type, id)