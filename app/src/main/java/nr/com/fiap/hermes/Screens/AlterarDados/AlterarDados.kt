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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AlterarDados(navController: NavController,cor_pref:Boolean,id:Int) {
    fun atualizarUsuario(usuario: Usuario,navController: NavController,usuarioLogado:String){
        var call = RetrofitFactory().getUsuarioService().atualizar(usuario,usuario.id)
        call.enqueue(object : Callback<Usuario>{
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                var usuario = response.body()
                navController.navigate("/inbox/{$usuarioLogado}")
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
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

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally) {
        Header(txt = "Alterar Dados")
        Input(
            valor = nome,
            funcao = { nome = it },
            placeholder = "Digite o seu nome",
            label = "Nome",
            keyBoard = KeyboardType.Text
        )
        Input(
            valor = email,
            funcao = { email = it },
            placeholder = "Digite o seu email",
            label = "Email",
            keyBoard = KeyboardType.Email
        )
        Input(
            valor = telefone,
            funcao = { telefone = it },
            placeholder = "Digite o seu telefone",
            label = "Telefone",
            keyBoard = KeyboardType.Phone
        )
        Input(
            valor = endereco,
            funcao = { endereco = it },
            placeholder = "Digite o seu endereço",
            label = "Endereço",
            keyBoard = KeyboardType.Text
        )
        Input(
            valor = senha,
            funcao = { senha = it },
            placeholder = "Digite a sua senha",
            label = "Senha",
            keyBoard = KeyboardType.Password
        )
        Botao(funcao = { atualizarUsuario(Usuario(0,nome,email,telefone,endereco,senha),navController,email)
                       navController.navigate("/inbox/${email}")}, txt = "Entrar")
    }
    }

