package nr.com.fiap.hermes.Screens.Inbox

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.Cards.Cards
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.ListaEmails.ListaEmails
//import nr.com.fiap.hermes.Lists.gerandoListaMockadaEmail
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.R
import nr.com.fiap.hermes.ui.theme.HermesTheme
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Inbox(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Header(txt = "Inbox")
        ListaEmails()




    }
}

@Preview(showSystemUi = true)
@Composable
private fun InboxPreview() {
    HermesTheme {
        var navController = rememberNavController()
        Inbox(navController)
    }
}

