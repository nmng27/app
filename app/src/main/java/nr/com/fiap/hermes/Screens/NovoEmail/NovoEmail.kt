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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NovoEmail(navController: NavController,cor_pref:Boolean,usuarioId:Int) {
    var destinatario by remember {
        mutableStateOf("")
    }
    var assunto by remember {
        mutableStateOf("")
    }
    var corpo by remember {
        mutableStateOf("")
    }
    val viewmodel = EmailViewModel(usuarioId,"")
    val email = viewmodel.emails
    val corPrimaria = if (cor_pref) Color(0xFFFFFFFF) else Color(0xFF000000) // Branco ou Preto

    Column(modifier = Modifier.fillMaxSize()
        .background(corPrimaria),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Header(txt = "Novo Email")
        Input(valor = destinatario,
            funcao = {destinatario = it},
            placeholder = "Destinatário",
            label = "Destinatário",
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
            val usuarioService = RetrofitFactory().getEmailService()
            usuarioService.enviar(Email(
                id = 0,
                destinatario = destinatario,
                remetente = "",
                assunto = assunto,
                corpo = corpo,
                categoria = "Enviados",
                usuarioId = usuarioId
            ))
            navController.navigate("inbox")
        }, txt = "Enviar")


    }
}


