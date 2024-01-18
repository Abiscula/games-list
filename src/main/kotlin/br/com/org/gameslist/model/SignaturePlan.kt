package br.com.org.gameslist.model

import java.math.BigDecimal

class SignaturePlan(type: String,
                    id: Int = 0,
                    val monthlyPayment: Double,
                    val includedGames: Int,
                    val reputationDiscount: Double
): Plan(type, id) {

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

    override fun toString(): String {
        return "Plano Assinatura\n" +
                "Tipo: $type \n" +
                "Id: $id \n" +
                "Mensalidade: $monthlyPayment \n" +
                "Jogos Incluidos: $includedGames \n" +
                "Percentual Desconto Reputacao: $reputationDiscount \n"
    }
}
