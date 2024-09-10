import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import nr.com.fiap.hermes.Comps.CardsEventos.CardsEventos
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.ui.theme.HermesTheme
import java.time.LocalDate


@Composable
fun Eventos(navController: NavController, cor_pref: Boolean, usuarioId: Int) {
    val viewModel = remember { EventoViewModel(usuarioId) }
    val eventos by viewModel.eventos.collectAsState(initial = emptyList()) // Observe the events list

    val corPrimaria = if (cor_pref) Color(0xFFFFFFFF) else Color(0xFF000000)
    var mes = LocalDate.now().month
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(txt = "Eventos")
        Text(
            text = "$mes",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xfff8B4513),
            modifier = Modifier.padding(12.dp)
        )

        LazyColumn {
            items(eventos) {
                ev ->
                Column {
                    CardsEventos(eveto = ev)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun EventosPreview() {
    HermesTheme {
        val navController = rememberNavController()
        Eventos(navController, true, 1)
    }
}
