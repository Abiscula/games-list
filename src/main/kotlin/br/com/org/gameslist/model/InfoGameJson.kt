package br.com.org.gameslist.model

import java.math.BigDecimal

data class InfoGameJson(
    val titulo: String,
    val capa: String,
    val preco: BigDecimal,
    val descricao: String)

