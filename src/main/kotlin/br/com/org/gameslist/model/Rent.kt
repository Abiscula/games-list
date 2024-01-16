package br.com.org.gameslist.model

data class Rent(val player: Player,
                val game: Game,
                val period: RentPeriod,
                val rentValue: Double = game.price * period.inDays
) {
    override fun toString(): String {
        return "Aluguel do ${game.title} por ${player.name} pelo valor de R$ $rentValue"
    }
}
