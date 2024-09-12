package nr.com.fiap.hermes.Screens.NovoEmail

import EmailViewModel
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import nr.com.fiap.hermes.Comps.TextArea.TextArea
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ui.theme.HermesTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun enviarEmail(email: Email) {
    val call = RetrofitFactory().getEmailService().enviar(email)
    call.enqueue(object : Callback<Email> {
        override fun onResponse(call: Call<Email>, response: Response<Email>) {
            if (response.isSuccessful) {
                // A resposta foi bem-sucedida
                val emailResposta = response.body()

            }
        }

        override fun onFailure(call: Call<Email>, t: Throwable) {

        }
    })
}




@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NovoEmail(navController: NavController,cor_pref:Boolean,usuarioLogado:String) {
    val credenciais = RetrofitFactory().getUsuarioService().credenciais(usuarioLogado)
    var destinatario = credenciais.email
    var remetente by remember {
        mutableStateOf("")
    }
    var assunto by remember {
        mutableStateOf("")
    }
    var corpo by remember {
        mutableStateOf("")
    }
    val viewmodel = EmailViewModel(credenciais.id,"Enviados")
    val email = viewmodel.emails
    val corPrimaria = if (cor_pref) Color(0xFFFFFFFF) else Color(0xFF000000) // Branco ou Preto

    Column(modifier = Modifier
        .fillMaxSize()
        .background(corPrimaria),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Header(txt = "Novo Email")
        Input(valor = remetente,
            funcao = {remetente = it},
            placeholder = "Digite para quem deseja enviar o email.",
            label = "Remetente",
            keyBoard = KeyboardType.Email)
        Input(valor = assunto,
            funcao = {assunto = it},
            placeholder = "Digite o assunto do email",
            label = "Assunto",
            keyBoard = KeyboardType.Text)
        TextArea(valor = corpo,
            funcao = {corpo = it} ,
            label = "Corpo do e-mail",
            placeholder = "Digite a mensagem",
            keyBoard = KeyboardType.Text)
        Botao(funcao = {
            enviarEmail(Email(0,0,remetente,usuarioLogado,"Enviados",assunto,corpo))
            navController.navigate("inbox")
        }, txt = "Enviar")


    }
}


