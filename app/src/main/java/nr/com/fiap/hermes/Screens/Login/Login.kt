package nr.com.fiap.hermes.Screens.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nr.com.fiap.hermes.R
import nr.com.fiap.hermes.ui.theme.HermesTheme

@Composable
fun Login() {
    var email by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.designer), contentDescription = "Logo da Hermes", modifier = Modifier.size(200.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Hermes",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color(0xfff8B4513)
        )
        TextField(value = email,
            onValueChange = {email = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            label = {
                Text(text = "E-mail", fontFamily = FontFamily.Serif)
            }, placeholder = {
                Text(text = "Digite o seu email",fontFamily = FontFamily.Serif)
            }, shape = CircleShape)
        TextField(value = senha,
            onValueChange = {senha = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            label = {
                Text(text = "Senha",fontFamily = FontFamily.Serif)
            }, placeholder = {
                Text(text = "Digite a sua senha",fontFamily = FontFamily.Serif)
            }, shape = CircleShape, keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password))
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color(0xfffFF8B4513))) {
            Text(text = "Entrar")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Cadastrar", fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color(0xfff8B4513))
        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun LoginPreview() {
    HermesTheme {
        Login()
    }
}