package nr.com.fiap.hermes.Comps.HeaderMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import nr.com.fiap.hermes.R
import nr.com.fiap.hermes.ui.theme.HermesTheme

@Composable
fun HeaderMenu(usuarioLogado:String,navController: NavController) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.designer),
                contentDescription = "Logo",
                modifier = Modifier.size(35.dp)
            )
            Text(
                text = "Hermes",
                fontFamily = FontFamily.Serif,
                color = Color(0xfff8B4513),
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = { navController.navigate("inbox/{$usuarioLogado}") }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "",
                    tint = Color(0xfff8B4513)
                )
            }
        }
}}

