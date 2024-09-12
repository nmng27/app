import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ThemeManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NovoEmail(usuarioId:Int,usuarioLogado:String,themeManager:ThemeManager) {
    val isDarkTheme = themeManager.isDarkTheme

    fun enviar(email:Email){
        val call = RetrofitFactory().getEmailService().enviar(email)
        call.enqueue(object : Callback<Email>{
            override fun onResponse(call: Call<Email>, response: Response<Email>) {
                var email = response.body()
            }

            override fun onFailure(call: Call<Email>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    var remetente by remember {
        mutableStateOf("")
    }
    var assunto by remember {
        mutableStateOf("")
    }
    var corpo by remember {
        mutableStateOf("")
    }
    var categoria = "Enviados"
    var favorito by remember {
        mutableStateOf(false)
    }


    Column {
        Header(txt = "Novo Email")
        Input(valor = remetente,
            funcao = {remetente = it},
            placeholder = "Digite o remetente",
            label = "Remetente",
            keyBoard = KeyboardType.Email)
        Input(valor = assunto,
            funcao = {assunto = it},
            placeholder = "Digite o assunto",
            label = "Assunto",
            keyBoard = KeyboardType.Text)
        Checkbox(checked = favorito,
            onCheckedChange = {favorito = it})
        Botao(funcao = {
            enviar(Email(0,usuarioId,remetente,usuarioLogado,"Enviados",assunto,corpo))
        }, txt ="Enviar")
    }
}