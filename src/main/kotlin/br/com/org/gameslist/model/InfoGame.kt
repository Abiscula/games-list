package br.com.org.gameslist.model

data class InfoGame(val info: infoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}