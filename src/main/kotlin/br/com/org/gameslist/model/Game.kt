package br.com.org.gameslist.model

data class Game(val title: String, val cover: String): Recommendable {
    var description: String? = null
    var price: Double = 0.0
    private val notesList = mutableListOf<Int>()
    override val avg: Double
        get() = notesList.average()


    constructor(title: String, cover: String, description: String, price: Double): this(title, cover) {
        this.description = description
        this.price = price
    }

    override fun recommend(note: Int) {
        notesList.add(note)
    }

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Título: $title \n" +
                "Capa: $cover \n" +
                "Preço: $price \n" +
                "Descrição: $description \n" +
                "Reputação: $avg \n"
    }

}