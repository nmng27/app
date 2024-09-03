package nr.com.fiap.hermes.Comps.Eventos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nr.com.fiap.hermes.ui.theme.HermesTheme

@Composable
fun Evento(nome:String,dia:Int,hora:Int,minuto:Int) {
    Column(modifier = Modifier.padding(12.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xfff8B4513))
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "$hora:$minuto",
                fontSize = 20.sp
                , color = Color.White,
                fontWeight = FontWeight.Bold)
            Text(text = nome,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold)
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "icone arrow",
                    tint = Color.White)
            }
        }

    }


}

@Preview(showSystemUi = true)
@Composable
private fun EventoPreview() {
    HermesTheme {
        Evento("Evento",26,12,12)
    }
}