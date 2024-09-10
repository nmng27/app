package nr.com.fiap.hermes.ViewModels.Email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory

class EmailViewModel:ViewModel() {
    var usuarioId = 0
    var emails:List<Email> = listOf()
        private set

    init {
        fetchEmails()
    }
    private fun fetchEmails(){
        viewModelScope.launch {
            try{
                emails = RetrofitFactory().getEmailService().listarPorUsuarioId(usuarioId)
            }catch(e:Exception){
                println("Erro")
            }
        }
    }
}