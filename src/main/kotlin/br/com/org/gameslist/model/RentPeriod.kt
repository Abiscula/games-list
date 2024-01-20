package br.com.org.gameslist.model

import java.time.LocalDate
import java.time.Period
import javax.persistence.Embeddable

@Embeddable
data class RentPeriod(val initialDate: LocalDate = LocalDate.now(),
                      val finalDate: LocalDate = LocalDate.now().plusDays(7),
                      val inDays: Int = Period.between(initialDate, finalDate).days) {
}
