package nr.com.fiap.hermes.Comps.Input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Input(valor:String, funcao:(String)->Unit, placeholder:String,label:String,keyBoard:KeyboardType) {
    TextField(value = valor,
        onValueChange = funcao,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        label = {
            Text(text = label, fontFamily = FontFamily.Serif)
        }, placeholder = {
            Text(text = placeholder,fontFamily = FontFamily.Serif)
        }, shape = CircleShape,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyBoard)
    )
}