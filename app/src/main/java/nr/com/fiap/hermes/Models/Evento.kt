package nr.com.fiap.hermes.Models

data class Evento(
    val id:Int,
    val usuario_id:Int,
    val nome:String,
    val dia:Int,
    val mes: Int,
    val ano:Int,
    val hora:Int,
    val minuto:Int
)
