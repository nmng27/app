package nr.com.fiap.hermes.Screens.AddEvento

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import nr.com.fiap.hermes.Comps.Botao.Botao
import nr.com.fiap.hermes.Comps.Header.Header
import nr.com.fiap.hermes.Comps.Input.Input
import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory
import nr.com.fiap.hermes.ui.theme.HermesTheme
import java.time.LocalDate
import java.time.LocalTime
import kotlin.math.min


fun converter_dados(mes:String,dia:String,hora:String,minuto:String,id:Int,usuario_id:Int,nome:String){
    var diaAux = dia.toInt()
    var horaAux = hora.toInt()
    var minutoAux = minuto.toInt()
    var mesAux:Int =0

    if(mes == "JANUARY"){
        mesAux = 1
    } else if(mes == "FEBRUARY"){
        mesAux = 2
    } else if(mes == "MARCH"){
        mesAux = 3
    }else if(mes == "APRIL"){
        mesAux = 4
    }else if(mes == "MAY"){
        mesAux = 5
    }else if(mes == "JUNE"){
        mesAux = 6
    } else if(mes == "JULY"){
        mesAux=7
    } else if(mes == "AUGUST"){
        mesAux = 8
    } else if(mes == "SEPTEMBER"){
        mesAux = 9
    }
    else if(mes == "OCTOBER"){
        mesAux = 10
    }
    else if(mes == "NOVEMBER"){
        mesAux = 11
    }
     else{
         mesAux = 12
    }
    var evento = Evento(
        id=id,
        usuario_id=usuario_id,
        nome =  nome,
        dia = diaAux,
        mes=mesAux,
        ano=LocalDate.now().year,
        hora=horaAux,
        minuto = minutoAux

    )
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddEvento(usuario_id: Int,navController: NavController) {
    var nome by remember {
        mutableStateOf("")
    }
    var mes = LocalDate.now().month
    var ano = LocalDate.now().year
    var anoAux = ano.toInt()
    var dia by remember {
        mutableStateOf("")
    }
    var hora by remember {
        mutableStateOf("")
    }
    var minuto by remember {
        mutableStateOf("")
    }
    var diaAux = dia.toInt()
    var mesAux = mes.toString()
    var mesAux2 = mesAux.toInt()
    var horaAuz = hora.toInt()
    var minAux = minuto.toInt()
    Column {
        Header(txt = "Add Evento")
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Input(valor = nome,
                funcao = {nome = it},
                placeholder = "Digite o nome do evento",
                label = "Evento",
                keyBoard = KeyboardType.Text)
            Input(valor = dia,
                funcao = {dia = it},
                placeholder = "Digite o dia do evento",
                label = "Dia",
                keyBoard = KeyboardType.Text)
            Input(valor = hora,
                funcao = {hora = it},
                placeholder = "Digite a  hora do evento",
                label = "Hora",
                keyBoard = KeyboardType.Text)
            Input(valor = minuto,
                funcao = {},
                placeholder = "Digite o minuto",
                label = "Minuto",
                keyBoard = KeyboardType.Text)
            Botao(funcao = {
                val eventoService = RetrofitFactory().getEventoService().
                add(Evento(id = 1,
                    nome = nome,
                    dia = diaAux,
                    mes=mesAux2,
                    ano = anoAux,
                    hora = horaAuz,
                    minuto = minAux,
                    usuario_id = usuario_id))
                           navController.navigate("inbox")},
                txt = "Add")
        }
    }
}
