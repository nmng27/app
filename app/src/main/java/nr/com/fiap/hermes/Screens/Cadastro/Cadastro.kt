package nr.com.fiap.hermes.Screens.Cadastro

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Models.Usuario
import nr.com.fiap.hermes.R
import nr.com.fiap.hermes.ui.theme.HermesTheme

@Composable
fun Cadastro(navController: NavController) {
    var nome by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var telefone by remember {
        mutableStateOf("")
    }
    var endereco by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.designer),
            contentDescription = "", modifier = Modifier.size(150.dp))
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Hermes",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color(0xfff8B4513)
        )
        Input(valor = nome,
            funcao = {nome = it},
            placeholder = "Digite o seu nome",
            label = "Nome",
            keyBoard = KeyboardType.Text)

        Input(valor = email,
            funcao = {email = it},
            placeholder = "Digite o seu e-mail",
            label = "E-mail",
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
        Button(onClick = {
            val novoUsuario = Usuario(
                id = 1,
                nome = nome,
                email = email,
                telefone = telefone,
                endereco = endereco,
                senha = senha
            )

        }, colors = ButtonDefaults.buttonColors(Color(0xfffFF8B4513))) {
            Text(text = "Entrar")
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun CadastroPreview() {
    HermesTheme {
        var navController = rememberNavController()
        Cadastro(navController)
    }
}