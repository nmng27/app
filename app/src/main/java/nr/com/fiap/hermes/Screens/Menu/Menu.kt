package nr.com.fiap.hermes.Screens.Menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import nr.com.fiap.hermes.Comps.ItemMenu.ItemMenu
import nr.com.fiap.hermes.R
import nr.com.fiap.hermes.ui.theme.HermesTheme

@Composable
fun Menu() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {

        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.designer), contentDescription = "Logo",
                    modifier = Modifier.size(35.dp))
                Text(text = "Hermes", fontFamily = FontFamily.Serif, color = Color(0xfff8B4513), fontWeight = FontWeight.Bold)
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "", tint = Color(0xfff8B4513))
                }
            }
            ItemMenu(Icone = Icons.Default.Person, txt = "Meu Perfil")
            ItemMenu(Icone = Icons.Default.DateRange, txt = "Meus Eventos")
            ItemMenu(Icone = Icons.Default.Home, txt = "Inbox")
            ItemMenu(Icone = Icons.Default.Email, txt = "Sends")
            ItemMenu(Icone = Icons.Default.Delete, txt = "Deleted")
            ItemMenu(Icone = Icons.Default.Build, txt = "Spam")
            ItemMenu(Icone = Icons.Default.Settings, txt = "Preferências")
        }

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color(0xfff8B4513))) {
                Text(text = "Novo Email")
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun MenuPreview() {
    HermesTheme {
        Menu()
    }
}