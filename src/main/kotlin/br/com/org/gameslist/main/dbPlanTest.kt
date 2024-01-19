package br.com.org.gameslist.main

import br.com.org.gameslist.data.Database
import br.com.org.gameslist.data.plan.PlansDAO
import br.com.org.gameslist.model.SeparatePlan
import br.com.org.gameslist.model.SignaturePlan

fun main() {
    val separate = SeparatePlan("BRONZE")
    val silver = SignaturePlan("PRATA", 9.90, 3, 0.15)
    val gold = SignaturePlan("OURO", 19.90, 5, 0.20)
    val platinum = SignaturePlan("PLATINA", 29.90, 10, 0.30)
    val diamond = SignaturePlan("DIAMANTE", 49.90, 20, 0.50)

    val manager = Database.getEntityManager()
    val plansDao = PlansDAO(manager)

    plansDao.add(separate)
    plansDao.add(silver)
    plansDao.add(gold)
    plansDao.add(platinum)
    plansDao.add(diamond)

    val listPlans = plansDao.getList()

    println(listPlans)

    manager.close()
}
