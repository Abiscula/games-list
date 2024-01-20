package br.com.org.gameslist.data.rent

import br.com.org.gameslist.data.game.GameEntity
import br.com.org.gameslist.data.player.PlayerEntity
import br.com.org.gameslist.model.RentPeriod
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table (name = "rent")
class RentEntity(
    @ManyToOne
    val player: PlayerEntity = PlayerEntity(),
    @ManyToOne
    val game: GameEntity = GameEntity(),
    @Embedded
    val period: RentPeriod = RentPeriod()
) {

    var rentValue = BigDecimal(0.0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

}