package nr.com.fiap.hermes.Screens.AddEvento

import EventoViewModel
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ui.theme.HermesTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun converterDados(mes: String, dia: String, hora: String, minuto: String, id: Int, usuario_id: Int, nome: String): Evento {
    val mesMap = mapOf(
        "JANUARY" to 1, "FEBRUARY" to 2, "MARCH" to 3, "APRIL" to 4,
        "MAY" to 5, "JUNE" to 6, "JULY" to 7, "AUGUST" to 8,
        "SEPTEMBER" to 9, "OCTOBER" to 10, "NOVEMBER" to 11, "DECEMBER" to 12
    )

    val diaAux = dia.toIntOrNull() ?: 1
    val mesAux = mesMap[mes] ?: 1
    val horaAux = hora.toIntOrNull() ?: 0
    val minutoAux = minuto.toIntOrNull() ?: 0
    val anoAux = LocalDate.now().year

    return Evento(
        id = id,
        usuario_id = usuario_id,
        nome = nome,
        dia = diaAux,
        mes = mesAux,
        ano = anoAux,
        hora = horaAux,
        minuto = minutoAux
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddEvento(usuarioLogado: String, navController: NavController) {
    val credenciais = RetrofitFactory().getUsuarioService().credenciais(usuarioLogado)
    val viewModel = EventoViewModel(credenciais.id)
    val eventos by viewModel.eventos.collectAsState(initial = emptyList()) // Observe the events list
    val prefs = RetrofitFactory().getPreferenciaService().listarPorUsuarioId(credenciais.id)
    val corPrimaria = if (prefs.tema == "Modo claro") Color(0xFFFFFFFF) else Color(0xFF000000)

    var nome by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var minuto by remember { mutableStateOf("") }

    Column {
        Header(txt = "Add Evento")
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Input(
                valor = nome,
                funcao = { nome = it },
                placeholder = "Digite o nome do evento",
                label = "Evento",
                keyBoard = KeyboardType.Text
            )
            Input(
                valor = dia,
                funcao = { dia = it },
                placeholder = "Digite o dia do evento",
                label = "Dia",
                keyBoard = KeyboardType.Text
            )
            Input(
                valor = hora,
                funcao = { hora = it },
                placeholder = "Digite a hora do evento",
                label = "Hora",
                keyBoard = KeyboardType.Text
            )
            Input(
                valor = minuto,
                funcao = { minuto = it },
                placeholder = "Digite o minuto",
                label = "Minuto",
                keyBoard = KeyboardType.Text
            )
            Botao(
                funcao = {
                    val eventoConvertido = converterDados(
                        mes = LocalDate.now().month.toString(), // Ajuste conforme necessário
                        dia = dia,
                        hora = hora,
                        minuto = minuto,
                        id = 0,
                        usuario_id = credenciais.id,
                        nome = nome
                    )
                    cadastrarEvento(eventoConvertido, navController)
                },
                txt = "Add"
            )
        }
    }
}

fun cadastrarEvento(evento: Evento, navController: NavController) {
    val call = RetrofitFactory().getEventoService().add(evento)
    call.enqueue(object : Callback<Evento> {
        override fun onResponse(call: Call<Evento>, response: Response<Evento>) {
            if (response.isSuccessful) {
                navController.navigate("inbox")
            } else {
                // Trate a falha de resposta
                println("Erro ao adicionar evento: ${response.message()}")
            }
        }

        override fun onFailure(call: Call<Evento>, t: Throwable) {
            // Trate a falha de rede
            println("Falha ao adicionar evento: ${t.message}")
        }
    })
}
