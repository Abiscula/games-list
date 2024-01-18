package br.com.org.gameslist.model

import com.google.gson.annotations.Expose
import java.math.BigDecimal

data class Game(@Expose val title: String, @Expose val cover: String): Recommendable {
    var description: String? = null
    var price: BigDecimal = BigDecimal(0.0)
    private val notesList = mutableListOf<Int>()
    var id = 0

    override val avg: Double
        get() = notesList.average()


    constructor(title: String, cover: String, price: BigDecimal, description: String?, id: Int = 0): this(title, cover) {
        this.price = price
        this.description = description
        this.id = id
    }

    override fun recommend(note: Int) {
        notesList.add(note)
    }

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Título: $title \n" +
                "Capa: $cover \n" +
                "Preço: ${String.format("%.2f", price)}\n" +
                "Descrição: $description \n" +
                "Reputação: ${String.format("%.2f", avg)} \n" +
                "Id: $id \n"
    }

}