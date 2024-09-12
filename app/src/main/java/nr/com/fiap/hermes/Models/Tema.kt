package nr.com.fiap.hermes.Models

enum class Tema {
    CLARO,
    ESCURO
}


data class UsuarioPreferencia(
    val id: Int,
    val tema: Tema
)