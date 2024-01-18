package br.com.org.gameslist.model

import java.math.BigDecimal

class SeparatePlan(type: String, id: Int = 0): Plan(type, id) {

    override fun getRentValue(rent: Rent): BigDecimal {
        var originalValue = super.getRentValue(rent)
        if(rent.player.avg > 8) {
            originalValue -=  originalValue * BigDecimal.valueOf(0.1)
        }
        return originalValue
    }

    override fun toString(): String {
        return "Plano Avulso \n" +
                "Tipo: $type \n" +
                "Id: $id \n"
    }
}

