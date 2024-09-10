package nr.com.fiap.hermes.Screens.AlterarDados

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.Models.Usuario
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ui.theme.HermesTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AlterarDados(navController: NavController,cor_pref:Boolean) {
    var nome by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var id = 0
    var telefone by remember {
        mutableStateOf("")
    }
    var endereco by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }
    val corPrimaria = if (cor_pref) Color(0xFFFFFFFF) else Color(0xFF000000) // Branco ou Preto
    Column(modifier = Modifier
        .fillMaxSize()
        .background(corPrimaria), horizontalAlignment = Alignment.CenterHorizontally) {
        Header(txt = "Alterar Dados")
        Input(valor = nome,
            funcao = {nome = it},
            placeholder = "Digite o seu nome",
            label = "Nome",
            keyBoard = KeyboardType.Text)
        Input(valor = email,
            funcao = {email = it},
            placeholder = "Digite o seu email",
            label = "Email",
            keyBoard = KeyboardType.Email)
        Input(valor = telefone,
            funcao = {telefone = it},
            placeholder = "Digite o seu telefone",
            label = "Telefone",
            keyBoard = KeyboardType.Phone)
        Input(valor = endereco,
            funcao = {endereco = it},
            placeholder = "Digite o seu endereço",
            label = "Endereço",
            keyBoard = KeyboardType.Text)
        Input(valor = senha,
            funcao = {senha = it},
            placeholder = "Digite a sua senha",
            label = "Senha",
            keyBoard = KeyboardType.Password)
        Botao(funcao = {
            var novoUsuario = Usuario(id,nome,email,
                telefone,endereco,senha)
            navController.navigate("/inbox") }, txt = "Alterar")
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AlterarDadosPreview() {
    HermesTheme {
        var navController = rememberNavController()
        AlterarDados(navController,true)
    }
}