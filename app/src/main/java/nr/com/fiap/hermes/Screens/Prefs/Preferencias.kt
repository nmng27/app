package nr.com.fiap.hermes.Screens.Prefs
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Radio.Radio
import nr.com.fiap.hermes.Models.Preferencias
import nr.com.fiap.hermes.Models.Tema
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ui.theme.HermesTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response









@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Preferencias(usuarioLogado:String,id:Int,usuarioId:Int) {
    fun alterar(preferencias: Preferencias){
        val call = RetrofitFactory().getPreferenciaService().upd(preferencias.id,preferencias)
        call.enqueue(object : Callback<Preferencias>{
            override fun onResponse(call: Call<Preferencias>, response: Response<Preferencias>) {
                var pref = response.body()
            }

            override fun onFailure(call: Call<Preferencias>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    var tema by remember {
        mutableStateOf("")
    }
    fun identificandoTema(valor:Int){
        if(valor == 0){
            tema = "Modo claro"
        }
        else{
            tema = "Modo escuro"
        }
    }
    var radio by remember {
        mutableStateOf(0)
    }
    Column {
        Header(txt = "Prefs")
        Text(text = "Modo de exibição do app",
            modifier = Modifier.padding(12.dp),
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color(0xfffFF8B4513))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
            Radio(txt = "Modo claro",
                funcao = { radio = 0 },
                valor = radio == 0)
            Radio(txt = "Modo escuro",
                funcao = { radio = 1
                         alterar(Preferencias(id,usuarioId,tema))},
                valor = radio == 1)
        }
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Termos de Uso - Hermes",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.Black
                )

                Text(
                    text = "Aceitação dos Termos\n" +
                            "Ao acessar o Hermes, você concorda em cumprir estes Termos de Uso. Se não concordar, não utilize o app.\n" +
                            "\n" +
                            "Uso do Aplicativo\n" +
                            "O Hermes é fornecido para uso pessoal e não comercial. Você não pode usar o app para atividades ilegais ou prejudiciais.\n" +
                            "\n" +
                            "Privacidade\n" +
                            "Seus dados serão coletados e utilizados conforme nossa Política de Privacidade. Consulte essa política para mais detalhes.\n" +
                            "\n" +
                            "Propriedade Intelectual\n" +
                            "Todo o conteúdo do app, incluindo textos, imagens e marcas, é de propriedade do Hermes ou de seus licenciadores. Você não tem permissão para copiar, distribuir ou modificar o conteúdo.\n" +
                            "\n" +
                            "Limitação de Responsabilidade\n" +
                            "O Hermes não se responsabiliza por quaisquer danos decorrentes do uso do aplicativo.\n" +
                            "\n" +
                            "Modificações\n" +
                            "Reservamo-nos o direito de modificar estes termos a qualquer momento. Notificaremos você sobre alterações importantes.\n" +
                            "\n" +
                            "Contato\n" +
                            "Em caso de dúvidas, entre em contato conosco pelo e-mail suporte@hermesapp.com.\n" +
                            "\n",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.Gray
                )


            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
private fun PreferenciasPreview() {
    HermesTheme {
        Preferencias(0,0,"0")
    }
}

