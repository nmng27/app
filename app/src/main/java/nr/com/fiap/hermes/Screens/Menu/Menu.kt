package nr.com.fiap.hermes.Screens.Menu

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.BtnMenu.BtnMenu
import nr.com.fiap.hermes.Comps.HeaderMenu.HeaderMenu
import nr.com.fiap.hermes.Comps.ItemMenu.ItemMenu
import nr.com.fiap.hermes.Comps.Radio.Radio
import nr.com.fiap.hermes.ui.theme.HermesTheme

@Composable
fun Menu(navController: NavController,usuarioLogado:String) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            HeaderMenu(navController = navController, usuarioLogado = usuarioLogado)
           ItemMenu(Icone = Icons.Default.Person, txt = "Meu Perfil",navController.navigate("perfil/{$usuarioLogado"))
            ItemMenu(Icone = Icons.Default.Home, txt = "Inbox", funcao = navController.navigate("inbox/${usuarioLogado}"))
            ItemMenu(Icone = Icons.Default.Email, txt = "Enviados", funcao = navController.navigate("enviados/{$usuarioLogado}"))
            ItemMenu(Icone = Icons.Default.Close, txt = "Excluídos", funcao = navController.navigate("excluidos/{$usuarioLogado}"))
            ItemMenu(Icone = Icons.Default.Delete, txt = "Spam", funcao = navController.navigate("spam/${usuarioLogado}"))
            ItemMenu(Icone = Icons.Default.DateRange, txt = "Calendário", funcao = navController.navigate("eventos/${usuarioLogado}"))

        }

        BtnMenu(navController,usuarioLogado)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MenuPreview() {
    HermesTheme {
        var navController = rememberNavController()
        Menu(navController = navController,"")
    }
}
