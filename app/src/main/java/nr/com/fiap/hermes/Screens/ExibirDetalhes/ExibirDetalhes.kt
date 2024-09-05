package nr.com.fiap.hermes.Screens.ExibirDetalhes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.ui.theme.HermesTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExibirDetalhes(email: Email,navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Column {
            Header(txt = "Details")
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = email.remetente,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xfff8B4513)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = email.assunto,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color(0xfff8B4513))
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = email.corpo)
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Botao(funcao = { /*TODO*/ }, txt = "Responder")
            Botao(funcao = { /*TODO*/ }, txt = "Favoritar")
            Botao(funcao = { /*TODO*/ }, txt = "Excluir")
        }

    }
}

var email = Email(1,1,"teste","teste","inbox","teste","teste")
@Preview(showSystemUi = true)
@Composable
private fun ExibirDetalhesPreview() {
    HermesTheme {
        var navController = rememberNavController()
        ExibirDetalhes(email = email, navController = navController)
    }
}