package br.com.org.gameslist.data

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/*
* O object é utilizado para criar objetos singleton.
* Um objeto singleton é um instância única de uma classe, ou seja, apenas uma única instância dessa classe é
* criada durante o ciclo de vida do programa.
*/
object Database {
    fun getConection(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/gameslistdb", "root", "root")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

}