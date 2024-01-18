package br.com.org.gameslist.data

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

/*
* O object é utilizado para criar objetos singleton.
* Um objeto singleton é um instância única de uma classe, ou seja, apenas uma única instância dessa classe é
* criada durante o ciclo de vida do programa.
*/
object Database {

    fun getEntityManager(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("gameslistdb")
        return factory.createEntityManager()
    }

}