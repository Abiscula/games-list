package br.com.org.gameslist.data

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "games")
class GameEntity(val title: String = "Titulo do jogo",
                 val cover: String = "Capa do jogo",
                 val price: BigDecimal = BigDecimal(0.0),
                 val description: String? = null,
                 @Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 val id: Int = 0) {

}