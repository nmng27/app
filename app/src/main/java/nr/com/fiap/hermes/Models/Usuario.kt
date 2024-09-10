package nr.com.fiap.hermes.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Usuario(
    val id:Int,
    val nome:String,
    val email:String,
    val telefone:String,
    val endereco:String,
    val senha:String
)
