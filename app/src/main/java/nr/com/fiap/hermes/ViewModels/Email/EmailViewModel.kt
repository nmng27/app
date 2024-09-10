import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory

class EmailViewModel(private val usuarioId: Int, private val categoria: String) : ViewModel() {

    var emails: List<Email> = listOf()
        private set

    init {
        fetchEmails() // Chama a função para buscar emails ao inicializar o ViewModel
    }

    private fun fetchEmails() {
        viewModelScope.launch {
            try {
                // Chamada ao serviço de email passando categoria e usuarioId
                emails = RetrofitFactory().getEmailService().listarPorCategoria(categoria, usuarioId)
            } catch (e: Exception) {
                // Aqui você pode logar o erro ou tratar de outra forma
                println("Erro ao buscar emails: ${e.message}")
            }
        }
    }
}
