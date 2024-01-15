data class Game(val title: String, val cover: String) {
    var description: String? = null

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Título: $title \n" +
                "Capa: $cover \n" +
                "Descrição: $description \n"
    }

}