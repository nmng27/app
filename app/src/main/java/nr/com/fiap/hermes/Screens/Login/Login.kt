package nr.com.fiap.hermes.Screens.Login

import android.util.Log
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.room.processor.Context
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.Models.Usuario
import nr.com.fiap.hermes.R
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ui.theme.HermesTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


fun logar(email: String, senha: String, navController: NavController) {
    val call = RetrofitFactory().getUsuarioService().login(email, senha)
    call.enqueue(object : Callback<Usuario> {
        override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
            if (response.isSuccessful) {
                val usuario = response.body()
                // Aqui você pode verificar mais dados se necessário
                navController.navigate("inbox/{$email}")
            } else {
                // Tratar casos de falha na resposta (e.g. credenciais inválidas)
                Log.e("Login", "Falha ao logar: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<Usuario>, t: Throwable) {
            // Tratar erro na comunicação (e.g. problema de conexão)
            Log.e("Login", "Erro na chamada de login: ${t.message}")
        }
    })
}



@Composable
fun Login(navController: NavController) {
    var email by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }

    
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.designer), contentDescription = "Logo da Hermes", modifier = Modifier.size(200.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Hermes",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color(0xfff8B4513)
        )
        Input(valor = email,
            funcao = {email = it},
            placeholder = "Digite o seu e-mail",
            label = "E-mail",
            keyBoard = KeyboardType.Email)
        Input(valor = senha,
            funcao = {senha = it},
            placeholder = "Digite a sua senha",
            label = "Senha",
            keyBoard = KeyboardType.Password)
       Botao(funcao = { logar(email,senha,navController) },
           txt = "Entrar")
        TextButton(onClick = {
            navController.navigate("/cadastro")
        }) {
            Text(text = "Cadastrar", fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color(0xfff8B4513))
        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun LoginPreview() {
    HermesTheme {
        var navController = rememberNavController()
        Login(navController)
    }
}