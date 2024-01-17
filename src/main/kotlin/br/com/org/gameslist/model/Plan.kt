package br.com.org.gameslist.model

open class Plan(val type: String) {

    fun getRentValue(rent: Rent): Double {
        return rent.game.price * rent.period.inDays
    }
}