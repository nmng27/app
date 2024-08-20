package nr.com.fiap.hermes.Models

data class Email(
    val id:Int,
    val usuarioId:Int,
    val remetente:String,
    val destinatario:String,
    val assunto:String,
    val corpo:String
)
