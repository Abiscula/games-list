package br.com.org.gameslist.model

data class Gamer(var name: String, var email: String) {
    var birthDate: String? = null
    var user: String? = null
    val userId: String? = null

    constructor(name: String, email: String, birthDate: String, user: String): this(name, email) {
        this.birthDate = birthDate
        this.user = user
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birthDate=$birthDate, user=$user, userId=$userId)"
    }


}

