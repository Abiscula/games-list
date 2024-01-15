package br.com.org.gameslist.model

import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
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
}

