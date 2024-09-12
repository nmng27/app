package nr.com.fiap.hermes.Screens.ExibirEventos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Comps.CardsEventos.CardsEventos
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ThemeManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExibirEventos(id: Int, navController: NavController,themeManager: ThemeManager) {
    // Define the state for event details
    var evento by remember { mutableStateOf<Evento?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Fetch event details
    LaunchedEffect(id) {
        buscarEventos(id, onSuccess = { fetchedEvento ->
            evento = fetchedEvento
            isLoading = false
        }, onError = { error ->
            errorMessage = error
            isLoading = false
        })
    }

    //val corPrimaria = if (cor_pref) Color(0xFFFFFFFF) else Color(0xFF000000) // Branco ou Preto
    val isDarkTheme = themeManager.isDarkTheme

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header(txt = "Detalhes Evento")
        Column(modifier = Modifier.padding(16.dp)) {
            if (isLoading) {
                Text("Loading...", fontSize = 20.sp)
            } else if (errorMessage != null) {
                Text("Error: $errorMessage", fontSize = 20.sp, color = Color.Red)
            } else {
                evento?.let {
                    CardsEventos(eveto = it)
                }
            }
        }
    }
}

fun buscarEventos(id: Int, onSuccess: (Evento) -> Unit, onError: (String) -> Unit) {
    val call = RetrofitFactory().getEventoService().buscarPorId(id)
    call.enqueue(object : Callback<Evento> {
        override fun onResponse(call: Call<Evento>, response: Response<Evento>) {
            if (response.isSuccessful) {
                response.body()?.let { onSuccess(it) }
            } else {
                onError("Error ${response.code()}: ${response.message()}")
            }
        }

        override fun onFailure(call: Call<Evento>, t: Throwable) {
            onError(t.message ?: "Unknown error")
        }
    })
}

