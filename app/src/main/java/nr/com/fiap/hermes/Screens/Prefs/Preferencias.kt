package nr.com.fiap.hermes.Screens.Prefs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Radio.Radio
import nr.com.fiap.hermes.Models.Preferencias
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ThemeManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PreferenciasScreen(
    id:Int,
    usuarioLogado: String,
    preferenciaViewModel: PreferenciaViewModel,
    themeManager: ThemeManager
) {
    var tema by remember { mutableStateOf("") }
    var radio by remember { mutableStateOf(0) }

    // Função para alterar o tema e atualizar a preferência
    fun updateTema() {
        tema = if (radio == 0) "Modo claro" else "Modo escuro"
        preferenciaViewModel.updatePref(Preferencias(id = 0, usuarioId = 0, tema = tema))
        themeManager.toggleTheme()
    }

    // Requisição para buscar credenciais do usuário

        val call = RetrofitFactory().getPreferenciaService().upd(id,tema)
        call.enqueue(object : Callback<Preferencias> {
            override fun onResponse(call: Call<Preferencias>, response: Response<Preferencias>) {
                val user = response.body()
                // Lógica para lidar com o usuário logado, se necessário
            }

            override fun onFailure(call: Call<Preferencias>, t: Throwable) {
                println("Erro ao buscar preferências: ${t.message}")
            }
        })


    // Layout da tela
    Column {
        Header(txt = "Prefs")
        Text(
            text = "Modo de exibição do app",
            modifier = Modifier.padding(12.dp),
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color(0xff8B4513) // Marrom
        )
        Row(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
            Radio(txt = "Modo claro", funcao = { radio = 0; updateTema() }, valor = radio == 0)
            Radio(txt = "Modo escuro", funcao = { radio = 1; updateTema() }, valor = radio == 1)
        }
        Card(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
        ) {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Termos de Uso - Hermes",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.Black
                )
                Text(
                    text = """
                        Aceitação dos Termos
                        Ao acessar o Hermes, você concorda em cumprir estes Termos de Uso. Se não concordar, não utilize o app.
                        
                        Uso do Aplicativo
                        O Hermes é fornecido para uso pessoal e não comercial. Você não pode usar o app para atividades ilegais ou prejudiciais.
                        
                        Privacidade
                        Seus dados serão coletados e utilizados conforme nossa Política de Privacidade. Consulte essa política para mais detalhes.
                        
                        Propriedade Intelectual
                        Todo o conteúdo do app, incluindo textos, imagens e marcas, é de propriedade do Hermes ou de seus licenciadores. Você não tem permissão para copiar, distribuir ou modificar o conteúdo.
                        
                        Limitação de Responsabilidade
                        O Hermes não se responsabiliza por quaisquer danos decorrentes do uso do aplicativo.
                        
                        Modificações
                        Reservamo-nos o direito de modificar estes termos a qualquer momento. Notificaremos você sobre alterações importantes.
                        
                        Contato
                        Em caso de dúvidas, entre em contato conosco pelo e-mail suporte@hermesapp.com.
                    """.trimIndent(),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.Gray
                )
            }
        }
    }
}

class PreferenciaViewModel(private val preferenciasRepository: Int, i: Int, s: String) : ViewModel() {
    fun updatePref(preferencias: Preferencias) {
        viewModelScope.launch {
            try {
                preferenciasRepository.updatePref(preferencias)
            } catch (e: Exception) {
                println("Erro ao atualizar preferências: ${e.message}")
            }
        }
    }
}

interface PreferenciasRepository {
    suspend fun updatePref(preferencias: Preferencias)
}
