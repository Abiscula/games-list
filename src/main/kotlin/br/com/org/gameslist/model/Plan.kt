package br.com.org.gameslist.model

abstract class Plan(val type: String) {

    open fun getRentValue(rent: Rent): Double {
        return rent.game.price * rent.period.inDays
    }
}