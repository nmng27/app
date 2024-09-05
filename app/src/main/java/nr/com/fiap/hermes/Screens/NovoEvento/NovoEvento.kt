package nr.com.fiap.hermes.Screens.NovoEvento

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.ui.theme.HermesTheme
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NovoEvento(navController: NavController) {
    var nome by remember {
        mutableStateOf("")
    }
    var data by remember {
        mutableStateOf("")
    }
    var hora by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Header(txt = "Novo Evento")
        Input(valor = nome,
            funcao = {nome = it},
            placeholder = "Digite o nome do evento",
            label = "Nome",
            keyBoard = KeyboardType.Text)
        Input(valor = data,
            funcao = {data = it},
            placeholder = "Digite a data do evento",
            label = "Data",
            keyBoard = KeyboardType.Text)
        Input(valor = "Hora",
            funcao = {hora = it},
            placeholder = "Digite a hora do evento",
            label = "Hora",
            keyBoard = KeyboardType.Text)
        Botao(funcao = { /*TODO*/ }, txt = "Adicionar")
    }
}

@Preview(showSystemUi = true)
@Composable
private fun NovoEventoPreview() {
    HermesTheme {
        NovoEvento(navController = rememberNavController())
    }
}