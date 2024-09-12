package nr.com.fiap.hermes.Services.RetrofitFactory

import nr.com.fiap.hermes.Models.Usuario
import nr.com.fiap.hermes.Services.Email.EmailService
import nr.com.fiap.hermes.Services.Evento.EventoService
import nr.com.fiap.hermes.Services.Preferencia.PreferenciaService
import nr.com.fiap.hermes.Services.Usuario.UsuarioService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "localhost:5000/api"
    private val retrofit = Retrofit.
                        Builder()
                            .baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create()).build()
    fun getUsuarioService():UsuarioService{
        return retrofit.create(UsuarioService::class.java)
    }

    fun getEmailService():EmailService{
        return retrofit.create(EmailService::class.java)
    }

    fun getEventoService():EventoService{
        return retrofit.create(EventoService::class.java)
    }

    fun getPreferenciaService():PreferenciaService{
        return retrofit.create(PreferenciaService::class.java)

    }
}
