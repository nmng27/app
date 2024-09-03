package nr.com.fiap.hermes.Comps.ListaEventos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nr.com.fiap.hermes.Comps.Eventos.EventosComps
import nr.com.fiap.hermes.Models.Eventos
import nr.com.fiap.hermes.ui.theme.HermesTheme
import java.time.LocalDate
import java.time.LocalDateTime

fun get_all_eventos():List<Eventos>{
    return listOf(
        Eventos(1, "teste", LocalDate.now(), LocalDateTime.now()),
        Eventos(2, "teste", LocalDate.now(), LocalDateTime.now()),
        Eventos(3, "teste", LocalDate.now(), LocalDateTime.now()),
        Eventos(4, "teste", LocalDate.now(), LocalDateTime.now()),
        Eventos(5, "teste", LocalDate.now(), LocalDateTime.now()),
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListaEventos() {
    Column {
        LazyColumn {
            items(get_all_eventos()){
                EventosComps(nome = it.nome,
                    data = it.data,
                    hora = it.hora)
            }
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