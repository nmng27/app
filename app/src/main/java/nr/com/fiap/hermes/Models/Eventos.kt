package nr.com.fiap.hermes.Models

import java.time.LocalDate
import java.time.LocalDateTime

data class Eventos(
    val id:Int,
    val nome:String,
    val data:LocalDate,
    val hora:LocalDateTime
)
