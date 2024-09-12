import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import nr.com.fiap.hermes.Comps.Cards.Cards
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Enviados(navController: NavController, usuarioiLogado: String) {
    var listaEmails:List<Email> by remember {
        mutableStateOf(listOf<Email>())
    }
    val credenciais = RetrofitFactory().getUsuarioService().credenciais(usuarioiLogado)
    val call = RetrofitFactory().getEmailService().listarPorCategoria("Enviados",credenciais.id)
    call.enqueue(
        object : Callback<List<Email>>{
            override fun onResponse(call: Call<List<Email>>, response: Response<List<Email>>) {
                listaEmails = response.body()!!
            }

            override fun onFailure(call: Call<List<Email>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }
    )
    Column {
        Header(txt = "Enviados")
        LazyColumn() {
            items(listaEmails
            ){
                Cards(email = it, funcao = {navController.navigate("detalhes")})
            }


        }
    }

}
