import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import nr.com.fiap.hermes.Comps.Cards.Cards
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ThemeManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Excluidos(navController: NavController,usuarioLogado:String,themeManager:ThemeManager) {
    val isDarkTheme = themeManager.isDarkTheme

    var listaEmails:List<Email> by remember {
        mutableStateOf(listOf<Email>())
    }

    val call = RetrofitFactory().getEmailService().listarPorCategoria("Excluidos",usuarioLogado)
    call.enqueue(
        object : Callback<List<Email>> {
            override fun onResponse(call: Call<List<Email>>, response: Response<List<Email>>) {
                listaEmails = response.body()!!
            }

            override fun onFailure(call: Call<List<Email>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }
    )
    Column {
        Header(txt = "Inbox")
        LazyColumn() {
            items(listaEmails
            ){
                Cards(email = it, funcao = {navController.navigate("detalhes")})
            }


        }
    }

}