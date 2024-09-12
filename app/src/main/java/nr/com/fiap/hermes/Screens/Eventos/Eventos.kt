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
import nr.com.fiap.hermes.Comps.CardsEventos.CardsEventos
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Eventos(navController: NavController, usuarioiLogado: String) {
    var listaEventos:List<Evento> by remember {
        mutableStateOf(listOf<Evento>())
    }
    val credenciais = RetrofitFactory().getUsuarioService().credenciais(usuarioiLogado)
    val call = RetrofitFactory().getEventoService().listarPorUsuarioId(credenciais.id)
    call.enqueue(
        object : Callback<List<Evento>>{
            override fun onResponse(call: Call<List<Evento>>, response: Response<List<Evento>>) {
                listaEventos = response.body()!!
            }

            override fun onFailure(call: Call<List<Evento>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }
    )
    Column {
        Header(txt = "Inbox")
        LazyColumn() {
            items(listaEventos
            ){
                CardsEventos(eveto = it)
            }


        }
    }

}
