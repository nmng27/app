import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import nr.com.fiap.hermes.Comps.CardsEventos.CardsEventos
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.ThemeManager

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Eventos(themeManager: ThemeManager) {
    Column {
        val isDarkTheme = themeManager.isDarkTheme

        var listaEventos:List<Evento> by remember {
            mutableStateOf(listOf<Evento>())
        }
        Header(txt = "Eventos")
        LazyColumn {
            items(listaEventos){
                CardsEventos(eveto = it)
            }
        }
    }
}