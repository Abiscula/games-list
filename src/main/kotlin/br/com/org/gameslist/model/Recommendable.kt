package br.com.org.gameslist.model

interface Recommendable {
    val avg: Double

    fun recommend(note: Int)
}