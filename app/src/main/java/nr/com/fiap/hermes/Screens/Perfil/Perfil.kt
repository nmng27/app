package nr.com.fiap.hermes.Screens.Perfil

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Models.Usuario
import nr.com.fiap.hermes.ui.theme.HermesTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Perfil(usuario: Usuario,navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Header(txt = "Meu Perfil")
        Text(text = usuario.nome,
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xfff8B4513),
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = { navController.navigate("/alterarDados") }) {
            Text(text = "Alterar Dados",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                color = Color(0xfff8B4513),
                textDecoration = TextDecoration.Underline
                )
        }
        TextButton(onClick = { navController.navigate("/login")}) {
            Text(text = "Excluir Conta",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                color = Color(0xfff8B4513),
                textDecoration = TextDecoration.Underline
            )
        }
        TextButton(onClick = { navController.navigate("/login") }) {
            Text(text = "Sair",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                color = Color(0xfff8B4513),
                textDecoration = TextDecoration.Underline
            )
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
private fun PerfilPreview() {
    HermesTheme {
        var navController = rememberNavController()
        Perfil(Usuario(1,
            "Nicholas Mangussi",
            "mangussinicholas@hermes.com",
            "t1",
            "e1",
            "pwd"),navController)
    }
}