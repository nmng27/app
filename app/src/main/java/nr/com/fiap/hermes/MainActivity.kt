package nr.com.fiap.hermes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Screens.Cadastro.Cadastro
import nr.com.fiap.hermes.Screens.Login.Login
import nr.com.fiap.hermes.ui.theme.HermesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HermesTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // criando o valor que armazene navegação
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login"){
                        composable(route = "/login") { Login(navController = navController) }
                        composable(route = "/cadastro") { Cadastro(navController = navController) }
                        composable(route="/inbox") {  }
                        composable(route = "/enviados") {  }
                        composable(route = "/excluidos") {  }
                        composable(route = "/spam") {  }
                        composable(route = "/favoritos") {  }
                        composable(route = "/exibirDetalhes") {  }
                        composable(route = "/novoEmail") {  }
                        composable(route = "/eventos") {  }
                        composable(route = "/novoEvento") {  }
                        composable(route = "/exibirEventos") {  }
                        composable(route = "/menu") {  }
                    }
                }
            }
        }
    }
}

