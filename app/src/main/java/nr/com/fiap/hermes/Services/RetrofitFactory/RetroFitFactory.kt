package nr.com.fiap.hermes.Services.RetrofitFactory

import nr.com.fiap.hermes.Services.Email.EmailService
import nr.com.fiap.hermes.Services.Evento.EventoService
import nr.com.fiap.hermes.Services.Preferencia.PreferenciaService
import nr.com.fiap.hermes.Services.Usuario.UsuarioService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "http:localhost:5000/api"  // Defina a URL base correta da sua API

    // Instância Retrofit preguiçosa
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Método genérico para criar qualquer serviço
    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    // Criando os serviços reutilizando a função genérica
    val usuarioService: UsuarioService = createService(UsuarioService::class.java)
    val emailService: EmailService = createService(EmailService::class.java)
    val eventoService: EventoService = createService(EventoService::class.java)
    val preferenciaService: PreferenciaService = createService(PreferenciaService::class.java)
}
