import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter


fun String.getAge(): Int {
    var age = 0
    val result = runCatching {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val birthDate = LocalDate.parse(this, formatter)
        val today = LocalDate.now()
        age = Period.between(birthDate, today).years
    }

    result.onFailure {
        throw Exception("Data de nascimento inválida")
    }

    return age
}
