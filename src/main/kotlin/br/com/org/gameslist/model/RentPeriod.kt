package br.com.org.gameslist.model

import java.time.LocalDate
import java.time.Period

data class RentPeriod(val initialDate: LocalDate,
                      val finalDate: LocalDate,
                      val inDays: Int = Period.between(initialDate, finalDate).days) {

}
