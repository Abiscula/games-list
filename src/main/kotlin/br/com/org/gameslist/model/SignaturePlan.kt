package br.com.org.gameslist.model

import java.math.BigDecimal

class SignaturePlan(type: String,
                    val monthlyPayment: Double,
                    val includedGames: Int,
                    val reputationDiscount: Double
): Plan(type) {

    override fun getRentValue(rent: Rent): BigDecimal {
        val totalMonthGames = rent.player.monthGame(rent.period.initialDate.monthValue).size+1

        return if (totalMonthGames <= includedGames) {
            BigDecimal.valueOf(0.0)
        } else {
            var originalValue = super.getRentValue(rent)
            if(rent.player.avg > 8) {
                originalValue -= originalValue * BigDecimal.valueOf(reputationDiscount)
            }
            originalValue
        }
    }
}
