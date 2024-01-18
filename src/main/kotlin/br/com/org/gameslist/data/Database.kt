package br.com.org.gameslist.data

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

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