package nr.com.fiap.hermes.Screens.NovoEmail

import android.os.Build
import androidx.annotation.RequiresApi
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
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.Comps.TextArea.TextArea
import nr.com.fiap.hermes.ui.theme.HermesTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NovoEmail() {
    var destinatario by remember {
        mutableStateOf("")
    }
    var assunto by remember {
        mutableStateOf("")
    }
    var corpo by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
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
        Botao(funcao = { /*TODO*/ }, txt = "Enviar")


    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
private fun NovoEmailPreview() {
    HermesTheme {
        NovoEmail()
    }
}