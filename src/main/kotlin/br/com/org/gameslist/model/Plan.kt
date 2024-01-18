package br.com.org.gameslist.model

import java.math.BigDecimal

sealed class Plan(val type: String, var id: Int = 0) {


    open fun getRentValue(rent: Rent): BigDecimal {
        val daysAsBigDecimal = BigDecimal.valueOf(rent.period.inDays.toLong())
        return rent.game.price * daysAsBigDecimal
    }
}