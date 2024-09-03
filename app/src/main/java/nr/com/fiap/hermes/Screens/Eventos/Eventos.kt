package nr.com.fiap.hermes.Screens.Eventos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.ListaEventos.ListaEventos
import nr.com.fiap.hermes.ui.theme.HermesTheme
import java.time.LocalDate
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Eventos() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Header(txt = "Eventos")
        Text(text = "${LocalDate.now().month}",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xfff8B4513), modifier = Modifier.padding(12.dp))
        ListaEventos()

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
private fun EventosPreview() {
    HermesTheme {
        Eventos()
    }
}