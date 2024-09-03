package nr.com.fiap.hermes.Comps.Emails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.ui.theme.HermesTheme
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Emails(remetente:String,assunto:String) {
    var data = LocalTime.now()
    var hora = data.hour
    var min = data.minute
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(12.dp)
            .background(Color(0xfff8B4513))
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(text = remetente, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text(text = assunto, color = Color.White)
            }
            Column {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "", tint = Color.White)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun EmailsPreview() {
    HermesTheme {
        Emails(remetente = "teste", assunto ="teste" )
    }
}