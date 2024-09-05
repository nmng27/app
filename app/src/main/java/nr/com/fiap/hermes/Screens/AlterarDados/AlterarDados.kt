package nr.com.fiap.hermes.Screens.AlterarDados

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.ui.theme.HermesTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AlterarDados(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Header(txt = "Alterar Dados")
        Input(valor = "",
            funcao = {},
            placeholder = "Digite o seu telefone",
            label = "Telefone",
            keyBoard = KeyboardType.Phone)
        Input(valor = "",
            funcao = {},
            placeholder = "Digite o seu endereço",
            label = "Endereço",
            keyBoard = KeyboardType.Text)
        Input(valor = "",
            funcao = {},
            placeholder = "Digite a sua senha",
            label = "Senha",
            keyBoard = KeyboardType.Password)
        Botao(funcao = { navController.navigate("/inbox") }, txt = "Alterar")
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AlterarDadosPreview() {
    HermesTheme {
        var navController = rememberNavController()
        AlterarDados(navController)
    }
}