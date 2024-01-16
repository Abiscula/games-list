package br.com.org.gameslist.model

data class Game(val title: String, val cover: String) {
    var description: String? = null
    var price: Double = 0.0

    constructor(title: String, cover: String, description: String, price: Double): this(title, cover) {
        this.description = description
        this.price = price
    }

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Título: $title \n" +
                "Capa: $cover \n" +
                "Descrição: $description \n"
    }

}