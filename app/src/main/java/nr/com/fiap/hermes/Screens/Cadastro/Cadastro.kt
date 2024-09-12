package nr.com.fiap.hermes.Screens.Cadastro

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.Models.Usuario
import nr.com.fiap.hermes.R
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ui.theme.HermesTheme
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call
import androidx.compose.ui.platform.LocalContext
import nr.com.fiap.hermes.Models.Preferencias

fun cadastrar(usuario: Usuario, navController: NavController, preferencias: Preferencias) {
    val call = RetrofitFactory().getUsuarioService().cadastrar(usuario)
    call.enqueue(object : Callback<Usuario> {
        override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
            if (response.isSuccessful) {
                val novoUsuario = response.body()

                // Navegar para "inbox" após sucesso no cadastro do usuário
                navController.navigate("/inbox/{${usuario.email}}")

                // Adicionar preferências associadas ao usuário recém-cadastrado
                val preferenciaCall = RetrofitFactory().getPreferenciaService().add(preferencias)
                preferenciaCall.enqueue(object : Callback<Preferencias> {
                    override fun onResponse(call: Call<Preferencias>, response: Response<Preferencias>) {
                        if (response.isSuccessful) {
                            Log.d("Cadastro", "Preferências adicionadas com sucesso.")
                        } else {
                            Log.e("Cadastro", "Erro ao adicionar preferências: ${response.errorBody()?.string()}")
                        }
                    }

                    override fun onFailure(call: Call<Preferencias>, t: Throwable) {
                        Log.e("Cadastro", "Erro ao adicionar preferências: ${t.message}")
                    }
                })
            } else {
                Log.e("Cadastro", "Erro no cadastro do usuário: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<Usuario>, t: Throwable) {
            Log.e("Cadastro", "Erro ao cadastrar usuário: ${t.message}")
        }
    })
}




@Composable
fun Cadastro(navController: NavController) {

    val context = LocalContext.current
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
    var navegarParaInbox by remember {
        mutableStateOf(true)
    }
    fun getUser():Usuario{
        val usuario = Usuario(0,nome,email,telefone,endereco,senha)
        return usuario
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
        Botao(funcao = {
                cadastrar(
                    navController = navController,
                    usuario = Usuario(0,nome,email,telefone,endereco,senha),
                    preferencias = Preferencias(0,0,"modo claro")
                )


        }, txt = "Entrar")
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