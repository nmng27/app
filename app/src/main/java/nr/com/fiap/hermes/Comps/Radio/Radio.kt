package nr.com.fiap.hermes.Comps.Radio

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import nr.com.fiap.hermes.ui.theme.HermesTheme

@Composable
fun Radio(txt:String,funcao:()->Unit,valor:Boolean) {
    Row(

        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = valor,
            onClick = { funcao },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xfff8B4513)
            )
        )
        Text(
            text = txt,
            fontFamily = FontFamily.Serif,
            color = Color(0xfff8B4513)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RadioPreview() { // Renomeando para evitar conflito
    HermesTheme {
        Radio("bla bla bn",{},false)
    }
}
