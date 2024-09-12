import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ThemeManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddEvento(usuarioLogado: String, navController: NavController,themeManager: ThemeManager) {
    val isDarkTheme = themeManager.isDarkTheme

    var nome by remember {
        mutableStateOf("")
    }
    var diaAux by remember {
        mutableStateOf("")
    }
    var dia = diaAux.toInt()
    var mesAux by remember {
        mutableStateOf("")
    }
    var mes = mesAux.toInt()
    var horaAux by remember {
        mutableStateOf("")
    }
    var hora = horaAux.toInt()
    var minAux by remember {
        mutableStateOf("")
    }
    var minuto = minAux.toInt()
    var ano = LocalDate.now().year.toInt()
    // Botão de cadastro
    Column {
        Header(txt = "Eventos")
        Input(valor = nome, funcao = {nome = it}, placeholder = "Nome", label = "Nome", keyBoard = KeyboardType.Text)
        Input(valor = diaAux, funcao = {diaAux = it}, placeholder = "Digite o dia", label = "Dia", keyBoard = KeyboardType.Number)
        Input(valor = mesAux, funcao = {mesAux = it}, placeholder = "Digite o mês", label = "Mês", keyBoard = KeyboardType.Number)
        Input(valor = horaAux, funcao = {horaAux=it}, placeholder = "Digite a hora", label = "Hora", keyBoard = KeyboardType.Number)
        Input(valor = minAux, funcao = {minAux = it}, placeholder = "Digite o minuto", label = "Minuto", keyBoard = KeyboardType.Number)
        Botao(
            funcao = {
                cadastrarEvento(Evento(0,0,nome,dia,mes,ano,hora,minuto), navController,usuarioLogado)
                navController.navigate("evento/${usuarioLogado}")
            },
            txt = "Add"
        )
    }

}

fun cadastrarEvento(evento: Evento, navController: NavController,usuarioLogado: String){
    val call:Call<Evento> = RetrofitFactory().getEventoService().add(evento)
    call.enqueue(object : Callback<Evento>{
        override fun onResponse(call: Call<Evento>, response: Response<Evento>) {
            var evento = response.body()
            navController.navigate("/inbox/{$usuarioLogado}")
        }

        override fun onFailure(call: Call<Evento>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}