package br.com.org.gameslist.model

class SeparatePlan(type: String): Plan(type) {

    override fun getRentValue(rent: Rent): Double {
        var originalValue = super.getRentValue(rent)
        if(rent.player.avg > 8) {
            originalValue -=  originalValue * 0.1
        }
        return originalValue
    }
}

