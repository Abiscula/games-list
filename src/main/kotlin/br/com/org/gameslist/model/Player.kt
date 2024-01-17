package br.com.org.gameslist.model

import java.util.*
import kotlin.random.Random

data class Player(var name: String, var email: String) {
    var birthDate: String? = null
    var user: String? = null
        set(value) {
            field = value
            if(userId.isNullOrBlank()) {
                createUserId()
            }
        }
    var userId: String? = null
        private set

    var plan: Plan = SeparatePlan("BRONZE")
    val searchedGames = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rent>()

    constructor(name: String, email: String, birthDate: String, user: String): this(name, email) {
        this.birthDate = birthDate
        this.user = user
        this.createUserId()
    }

    init {
        this.userValidator()
        this.email = this.mailValidator()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birthDate=$birthDate, user=$user, userId=$userId)"
    }

    fun createUserId() {
        val randomNumber = Random.nextInt(10000)
        val tag = String.format("%04d", randomNumber)

        this.userId = "$user#$tag"
    }

    fun userValidator() {
        if(this.name.isNullOrBlank()) {
            throw IllegalArgumentException("Nome está em branco")
        }
    }

    fun mailValidator(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(this.email)) {
            return this.email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun gameRent(game: Game, period: RentPeriod): Rent {
        val rent = Rent(this, game, period)
        rentedGames.add(rent)
        return rent
    }

    fun monthGame(month: Int): List<String> {
        return rentedGames
            .filter { rent -> rent.period.initialDate.monthValue == month }
            .map { rent -> rent.game.title }
    }

    companion object {
        fun createPlayer(read: Scanner): Player {
            println("Boas vindas. Digite seu nome:")
            val name = read.nextLine()
            println("Informe seu e-mail:")
            val email = read.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = read.nextLine()

            if(option.equals("s", true)) {
                println("Informe sua data de nascimento (DD/MM/AAAA):")
                val birthDate = read.nextLine()
                println("Informe seu nome de usuário:")
                val user = read.nextLine()

                return Player(name, email, birthDate, user)
            } else {
                return Player(name, email)
            }
        }
    }
}

