package nr.com.fiap.hermes.Screens.Favoritos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.ListaEmails.ListaEmails
import nr.com.fiap.hermes.ui.theme.HermesTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Favoritos(navController: NavController) {
    Column {
        Header(txt = "Favoritos")
        ListaEmails()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
private fun FavoritosPreview() {
    HermesTheme {
        var navController = rememberNavController()
        Favoritos(navController)
    }
}