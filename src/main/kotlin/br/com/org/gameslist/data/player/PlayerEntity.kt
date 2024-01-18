package br.com.org.gameslist.data.player

import javax.persistence.*

@Entity
@Table(name = "players")
class PlayerEntity(
    val name: String = "Nome do jogador",
    val email: String = "email@email.com",
    val birthDate: String? = null,
    val user: String? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0) {}