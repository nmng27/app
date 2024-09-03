package nr.com.fiap.hermes.Screens.ExibirEventos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nr.com.fiap.hermes.Comps.CardsEventos.CardsEventos
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Models.Evento

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExibirEventos(evento:Evento) {
    Column {
        Header(txt = "Detalhes Evento")
        CardsEventos(eveto = evento)
    }
}