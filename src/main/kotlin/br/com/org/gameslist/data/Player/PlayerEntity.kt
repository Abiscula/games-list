package br.com.org.gameslist.data.Player

import javax.persistence.*

@Entity
@Table(name = "players")
class PlayerEntity(
    val name: String = "Nome do jogador",
    val email: String = "Email do jogador",
    val birthDate: String? = "Data de nascimento",
    val user: String? = "Usuário do jogador",
    @Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0) {}