package nr.com.fiap.hermes.Screens.Inbox

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.Cards.Cards
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.ListaEmails.ListaEmails
import nr.com.fiap.hermes.ViewModels.Email.EmailViewModel
import nr.com.fiap.hermes.ui.theme.HermesTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Inbox(navController: NavController, cor_pref: Boolean) {
    val corPrimaria = if (cor_pref) Color(0xFFFFFFFF) else Color(0xFF000000) // Branco ou Preto
   val viewModel = EmailViewModel()
    val emails = viewModel.emails
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(corPrimaria)
    ) {
        Header(txt = "Inbox")
        LazyColumn {
            items(emails){
                    email ->
                Column {
                    Cards(email = email, funcao = {navController.navigate("exibirDetalhes")})
            }
        }

    }
}}

