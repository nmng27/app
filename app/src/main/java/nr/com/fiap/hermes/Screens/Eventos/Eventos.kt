package nr.com.fiap.hermes.Screens.Eventos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import nr.com.fiap.hermes.ui.theme.HermesTheme
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Eventos() {
    var mes = LocalDate.now().month
    Column {
        Header(txt = "Meus Eventos")
        Column(modifier = Modifier.fillMaxWidth() .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$mes", fontSize = 30.sp, fontFamily = FontFamily.Serif, color = Color(0xfff8B4513))
        }
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