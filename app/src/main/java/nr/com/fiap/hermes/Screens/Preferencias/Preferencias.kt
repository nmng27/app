package nr.com.fiap.hermes.Screens.Preferencias

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Radio.Radio
import nr.com.fiap.hermes.Models.Preferencias
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ui.theme.HermesTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Preferencia(usuarioLogado:String,id:Int) {
    var credenciais = RetrofitFactory().getUsuarioService().credenciais(usuarioLogado)
    var preferencia by remember { mutableStateOf(0) }
    var valor by remember { mutableStateOf(false) }
    var tema by remember {
        mutableStateOf("")
    }
    fun identificartema():String{

        if(preferencia == 0){
            tema = "Claro"
        }
        else {
            tema = "escuro"
        }
        return tema
    }
    Column {
        // Cabeçalho
        Header(txt = "Preferências")

        // Modo de exibição
        Text(
            text = "Modo de Exibição do App",
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xFFF8B4513),
            modifier = Modifier.padding(12.dp),
            fontWeight = FontWeight.Bold
        )

        // Opções de Modo Claro e Modo Escuro
        Row {
            Radio(txt = "Modo Claro", funcao = {
                preferencia = 0
                valor = true
                RetrofitFactory().getPreferenciaService().upd(credenciais.id, Preferencias(id,credenciais.id,tema))
            }, valor = preferencia == 0)

            Radio(txt = "Modo Escuro", funcao = {
                preferencia = 1
                valor = false

            }, valor = preferencia == 1)
        }

        // Política de privacidade
        Text(
            text = "Política de privacidade",
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xFFF8B4513),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(12.dp)
        )

        // Card com o texto da política
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8B4513))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Política de Privacidade - Hermes",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Na Hermes, valorizamos sua privacidade. Seus dados pessoais são coletados apenas para oferecer uma experiência aprimorada e personalizada. Não compartilhamos suas informações sem o seu consentimento. Você tem total controle sobre seus dados e pode solicitar sua exclusão a qualquer momento.",
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
private fun PreferenciaPreview() {
    HermesTheme {
        Preferencia("1",1)
    }
}
