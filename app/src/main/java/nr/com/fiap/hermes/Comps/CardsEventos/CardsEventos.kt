package nr.com.fiap.hermes.Comps.CardsEventos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.ui.theme.HermesTheme

@Composable
fun CardsEventos(eveto:Evento) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .height(150.dp), colors = CardDefaults.cardColors(Color(0xfff8B4513))
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "", tint = Color.White)

            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color.White)
            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Evento: ${eveto.nome}", fontSize = 30.sp, color = Color.White)
            Text(text = "Data: ${eveto.dia}/${eveto.mes}", fontSize = 20.sp, color = Color.White)
            Text(text = "Hora: ${eveto.hora}:${eveto.minuto}", fontSize = 20.sp, color = Color.White)
        }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun CardsEventosPreview() {
    HermesTheme {
        CardsEventos(Evento(1,3,"Evento 1",26,12,2024,12,12))
    }
}