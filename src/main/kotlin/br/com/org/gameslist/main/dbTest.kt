package br.com.org.gameslist.main

import br.com.org.gameslist.data.Database

fun main() {
    val connection = Database.getConection()
    println(connection)
}