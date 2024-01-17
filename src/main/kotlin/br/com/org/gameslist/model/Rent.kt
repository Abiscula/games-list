package br.com.org.gameslist.model

import java.math.BigDecimal

data class Rent(val player: Player,
                val game: Game,
                val period: RentPeriod) {

    val rentValue: BigDecimal = player.plan.getRentValue(this)

    override fun toString(): String {
        return "Aluguel do ${game.title} por ${player.name} pelo valor de R$ ${String.format("%.2f", rentValue)}"
    }
}
