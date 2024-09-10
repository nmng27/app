import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import nr.com.fiap.hermes.Comps.Cards.Cards
import nr.com.fiap.hermes.Comps.Header.Header

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Inbox(navController: NavController, cor_pref: Boolean) {
    val corPrimaria = if (cor_pref) Color(0xFFFFFFFF) else Color(0xFF000000) // Branco ou Preto
    val viewModel = EmailViewModel(0,"Excluidos")
    val emails = viewModel.emails
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(corPrimaria)
    ) {
        Header(txt = "Deleted")
        LazyColumn {
            items(emails){
                    email ->
                Column {
                    Cards(email = email, funcao = {navController.navigate("exibirDetalhes")})
                }
            }

        }
    }
}

