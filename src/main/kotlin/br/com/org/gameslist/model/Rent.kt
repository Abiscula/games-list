package br.com.org.gameslist.model

data class Rent(val player: Player, val game: Game) {
    override fun toString(): String {
        return "Aluguel do ${game.title} por ${player.name}"
    }
}
