import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Services.Email.EmailService
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaEmailViewModel(private val usuarioId: Int, private val categoria: String) : ViewModel() {
    var emails: List<Email>? = null
        private set

    init {
        carregarEmails()  // Carregar emails ao inicializar o ViewModel
    }

    private fun carregarEmails() {
        viewModelScope.launch {
            val emailService = RetrofitFactory().getEmailService()
            val call = emailService.listarPorCategoria(categoria, usuarioId)
            call.enqueue(object : Callback<List<Email>> {
                override fun onResponse(call: Call<List<Email>>, response: Response<List<Email>>) {
                    if (response.isSuccessful) {
                        emails = response.body()  // Atualiza a lista de emails
                    } else {
                        // Trate o caso de resposta não bem-sucedida
                        println("Erro: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<Email>>, t: Throwable) {
                    // Lida com falhas de rede ou outros erros
                    println("Erro de conexão: ${t.message}")
                }
            })
        }
    }
}
