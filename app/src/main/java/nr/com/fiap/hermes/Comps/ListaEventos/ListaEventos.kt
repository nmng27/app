package nr.com.fiap.hermes.Comps.ListaEventos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nr.com.fiap.hermes.Comps.Eventos.Evento
import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.ui.theme.HermesTheme
import java.time.LocalDate
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
fun gerando_lista(): List<Evento> {
    return listOf(
        Evento(
            id = 1,
            nome = "Evento 1",
            usuario_id = 3,
            dia = LocalDate.now().dayOfMonth, // Correção para dayOfYear para dayOfMonth
            mes = LocalDate.now().monthValue, // Correção para monthValue
            hora = LocalTime.now().hour,
            minuto = LocalTime.now().minute,
            ano = LocalDate.now().year
        ),
        Evento(id = 1,
        nome = "Evento 1",
        usuario_id = 3,
        dia = LocalDate.now().dayOfMonth, // Correção para dayOfYear para dayOfMonth
        mes = LocalDate.now().monthValue, // Correção para monthValue
        hora = LocalTime.now().hour,
        minuto = LocalTime.now().minute,
        ano = LocalDate.now().year
    )
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListaEventos() {
    val eventos = gerando_lista()
    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(gerando_lista()){
            Evento(nome = it.nome,
                dia = it.dia,
                hora = it.hora,
                minuto = it.minuto)

        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ListaEventosPreview() {
    HermesTheme {
        ListaEventos()
    }
}
