package br.com.org.gameslist.model

import java.math.BigDecimal

class SeparatePlan(type: String): Plan(type) {

    override fun getRentValue(rent: Rent): BigDecimal {
        var originalValue = super.getRentValue(rent)
        if(rent.player.avg > 8) {
            originalValue -=  originalValue * BigDecimal.valueOf(0.1)
        }
        return originalValue
    }
}

