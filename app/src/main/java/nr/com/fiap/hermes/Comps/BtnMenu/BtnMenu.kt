package nr.com.fiap.hermes.Comps.BtnMenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BtnMenu(navController: NavController,usuarioLogado:String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.End
    ) {
        Button(
            onClick = { navController.navigate("novoEmail/{$usuarioLogado}") },
            colors = ButtonDefaults.buttonColors(Color(0xfff8B4513)),
        ) {
            Text(text = "Novo Email", fontWeight = FontWeight.Bold)
        }
    }
}