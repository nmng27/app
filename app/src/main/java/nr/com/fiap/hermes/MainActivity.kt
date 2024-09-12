package nr.com.fiap.hermes

import AddEvento
import Enviados
import Eventos
import Excluidos
import Inbox
import Perfil
import Spam
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nr.com.fiap.hermes.Screens.AlterarDados.AlterarDados
import nr.com.fiap.hermes.Screens.Cadastro.Cadastro
import nr.com.fiap.hermes.Screens.Login.Login
import nr.com.fiap.hermes.Screens.Prefs.PreferenciaViewModel
import nr.com.fiap.hermes.Screens.Prefs.PreferenciasScreen
import nr.com.fiap.hermes.ui.theme.HermesTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HermesTheme {
                val themeManager = remember { ThemeManager() }
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            Login(navController = navController)
                        }
                        composable(route = "cadastro") {
                            Cadastro(navController = navController)
                        }
                        composable(route = "inbox/{usuarioLogado}") { backStackEntry ->
                            val usuarioId = backStackEntry.arguments?.getString("usuarioLogado") ?: ""
                            Inbox(navController = navController, themeManager = themeManager, usuarioLogado = usuarioId)
                        }
                        composable(route = "enviados/{usuarioLogado}") { backStackEntry ->
                            val usuarioId = backStackEntry.arguments?.getString("usuarioLogado") ?: ""
                            Enviados(navController = navController, usuariLogado = usuarioId, themeManager = themeManager)
                        }
                        composable(route = "excluidos/{usuarioLogado}") { backStackEntry ->
                            val usuarioId = backStackEntry.arguments?.getString("usuarioLogado") ?: ""
                            Excluidos(navController = navController, usuarioLogado = usuarioId, themeManager = themeManager)
                        }
                        composable(route = "spam/{usuarioLogado}") { backStackEntry ->
                            val usuarioId = backStackEntry.arguments?.getString("usuarioLogado") ?: ""
                            Spam(navController = navController, usuarioLogado = usuarioId, themeManager = themeManager)
                        }
                        composable(route = "eventos/{usuarioLogado}") { backStackEntry ->
                            val usuarioId = backStackEntry.arguments?.getString("usuarioLogado") ?: ""
                            Eventos(themeManager = themeManager)
                        }
                        composable(route = "addEvento/{usuarioLogado}") { backStackEntry ->
                            val usuarioLogado = backStackEntry.arguments?.getString("usuarioLogado") ?: ""
                            AddEvento(usuarioLogado = usuarioLogado, navController = navController, themeManager = themeManager)
                        }
                        composable(route = "prefs/{usuarioLogado}") { backStackEntry ->
                            val usuarioLogado = backStackEntry.arguments?.getString("usuarioLogado") ?: ""
                            val id = 1 // Definir como você está obtendo o ID
                            val usuarioId = 1 // Definir como você está obtendo o ID
                            PreferenciasScreen(
                                usuarioLogado = usuarioLogado,
                                id = id,
                                preferenciaViewModel = PreferenciaViewModel(id, 0, "tema"),
                                themeManager = themeManager
                            )
                        }
                        composable(route = "perfil/{usuarioLogado}") { backStackEntry ->
                            val usuarioLogado = backStackEntry.arguments?.getString("usuarioLogado") ?: ""
                            Perfil(usuarioLogado = usuarioLogado, navController = navController, themeManager = themeManager)
                        }
                        composable(route = "alterarDados/{id}") { backStackEntry ->
                            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
                            AlterarDados(
                                navController = navController,
                                id = id,
                                themeManager = themeManager
                            )
                        }
                    }
                }
            }
        }
    }
}
