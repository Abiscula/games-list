package br.com.org.gameslist.model

class SignaturePlan(type: String,
                    val monthlyPayment: Double,
                    val includedGames: Int,
                    val reputationDiscount: Double
): Plan(type) {

    override fun getRentValue(rent: Rent): Double {
        val totalMonthGames = rent.player.monthGame(rent.period.initialDate.monthValue).size+1

        return if (totalMonthGames <= includedGames) {
            0.0
        } else {
            var originalValue = super.getRentValue(rent)
            if(rent.player.avg > 8) {
                originalValue -= originalValue * reputationDiscount
            }
            originalValue
        }
    }
}
