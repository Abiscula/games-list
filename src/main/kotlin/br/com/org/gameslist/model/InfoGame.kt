package br.com.org.gameslist.model

data class InfoGame(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}