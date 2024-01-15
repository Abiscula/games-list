class Game(val title: String, val cover: String) {
    val description = ""

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Título: $title \n" +
                "Capa: $cover \n" +
                "Descrição: $description \n"
    }

}