package nr.com.fiap.hermes.Screens.ExibirEventos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.CardsEventos.CardsEventos
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.ui.theme.HermesTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExibirEventos(evento:Evento,navController: NavController) {
    Column {
        Header(txt = "Detalhes Evento")
        CardsEventos(eveto = evento)
    }
}

var evento = Evento(1,1,"teste",12,12,12,12,12)

@Preview(showSystemUi = true)
@Composable
private fun ExibirEventosPreview() {
    HermesTheme {
        var navController = rememberNavController()
        ExibirEventos(evento = evento, navController = navController)
    }
}