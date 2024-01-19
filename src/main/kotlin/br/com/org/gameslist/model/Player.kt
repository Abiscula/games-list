package br.com.org.gameslist.model

import java.util.*
import kotlin.random.Random

data class Player(var name: String, var email: String): Recommendable {
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
    var id = 0
    var plan: Plan = SeparatePlan("BRONZE")
    val searchedGames = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rent>()
    private val notesList = mutableListOf<Int>()
    override val avg: Double
        get() = notesList.average()

    val recommendedGamesList = mutableListOf<Game>()

    constructor(name: String, email: String, birthDate: String?, user: String?, id: Int = 0): this(name, email) {
        this.birthDate = birthDate
        this.user = user
        this.id = id
        this.createUserId()
    }

    init {
        this.nameValidator()
        this.email = this.mailValidator()
    }

    override fun recommend(note: Int) {
        notesList.add(note)
    }

    fun recommendGame(game: Game, note: Int) {
        game.recommend(note)
        recommendedGamesList.add(game)
    }

    override fun toString(): String {
        return "Gamer: \n" +
                "Nome: $name, \n" +
                "Email: $email \n" +
                "Data Nascimento: $birthDate \n" +
                "Usuario: $user \n" +
                "ID usuario: $userId \n" +
                "Reputação: ${String.format("%.2f", avg)} \n" +
                "Id: $id \n"
    }

    fun createUserId() {
        val randomNumber = Random.nextInt(10000)
        val tag = String.format("%04d", randomNumber)

        this.userId = "$user#$tag"
    }

    fun nameValidator() {
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

