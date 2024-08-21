package nr.com.fiap.hermes.Comps.TextArea

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nr.com.fiap.hermes.ui.theme.HermesTheme

@Composable
fun TextArea(valor:String,funcao:(String)->Unit,label:String,placeholder:String,keyBoard:KeyboardType) {
    TextField(value = valor,
        onValueChange = funcao,
        modifier = Modifier
            .size(400.dp) .padding(16.dp),
        label = {
            Text(text = label, fontFamily = FontFamily.Serif)
        }, placeholder = {
            Text(text = placeholder,fontFamily = FontFamily.Serif)
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyBoard)
    )
}

@Preview(showSystemUi = true)
@Composable
private fun TextAreaPreview() {
    HermesTheme {
        TextArea(valor = "", funcao = {}, label = "Teste", placeholder = "Teste", keyBoard = KeyboardType.Text)
    }
}