package nr.com.fiap.hermes.Screens.ExibirDetalhes

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
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExibirDetalhes(id: Int, navController: NavController,usuarioLogado:String) {
    // Define the state for email details
    var credenciais = RetrofitFactory().getUsuarioService().credenciais(usuarioLogado)
    var email by remember { mutableStateOf<Email?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Fetch email details
    LaunchedEffect(id) {
        buscarDetalhes(id, onSuccess = { fetchedEmail ->
            email = fetchedEmail
            isLoading = false
        }, onError = { error ->
            errorMessage = error
            isLoading = false
        })
    }

    //val corPrimaria = if (cor_pref) Color(0xFFFFFFFF) else Color(0xFF000000) // Branco ou Preto

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Header(txt = "Details")
                Column(modifier = Modifier.padding(16.dp)) {
                    if (isLoading) {
                        Text("Loading...", fontSize = 20.sp)
                    } else if (errorMessage != null) {
                        Text("Error: $errorMessage", fontSize = 20.sp, color = Color.Red)
                    } else {
                        email?.let {
                            Text(
                                text = it.assunto,
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xfff8B4513)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(text = it.corpo)
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Botao(funcao = { navController.navigate("/responder") }, txt = "Responder")
                Botao(funcao = {
                    email?.let { favoritar(it.id, navController) }
                }, txt = "Favoritar")
                Botao(funcao = {
                    email?.let { excluir(it.id, navController) }
                }, txt = "Excluir")
            }
        }
    }
}

fun buscarDetalhes(id: Int, onSuccess: (Email) -> Unit, onError: (String) -> Unit) {
    val call = RetrofitFactory().getEmailService().buscarId(id)
    call.enqueue(object : Callback<Email> {
        override fun onResponse(call: Call<Email>, response: Response<Email>) {
            if (response.isSuccessful) {
                response.body()?.let { onSuccess(it) }
            } else {
                onError("Error ${response.code()}: ${response.message()}")
            }
        }

        override fun onFailure(call: Call<Email>, t: Throwable) {
            onError(t.message ?: "Unknown error")
        }
    })
}

fun excluir(id: Int, navController: NavController) {
    val call = RetrofitFactory().getEmailService().deletar(id)
    call.enqueue(object : Callback<Email> {
        override fun onResponse(call: Call<Email>, response: Response<Email>) {
            if (response.isSuccessful) {
                navController.navigate("inbox")
            } else {
                // Handle error
            }
        }

        override fun onFailure(call: Call<Email>, t: Throwable) {
            // Handle error
        }
    })
}

fun favoritar(id: Int, navController: NavController) {
    val call = RetrofitFactory().getEmailService().favoritar(id)
    call.enqueue(object : Callback<Email> {
        override fun onResponse(call: Call<Email>, response: Response<Email>) {
            if (response.isSuccessful) {
                navController.navigate("inbox")
            } else {
                // Handle error
            }
        }

        override fun onFailure(call: Call<Email>, t: Throwable) {
            // Handle error
        }
    })
}
