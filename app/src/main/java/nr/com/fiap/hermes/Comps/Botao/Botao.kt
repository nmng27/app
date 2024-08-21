package nr.com.fiap.hermes.Comps.Botao

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Botao(funcao:()->Unit,txt:String) {
    Button(onClick = funcao , colors = ButtonDefaults.buttonColors(Color(0xfffFF8B4513))) {
        Text(text = txt)
    }
}

