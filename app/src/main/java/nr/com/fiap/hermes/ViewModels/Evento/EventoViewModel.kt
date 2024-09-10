import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.Services.RetrofitFactory.RetrofitFactory

class EventoViewModel(private val usuarioId: Int) : ViewModel() {

    // Estado observável de eventos usando StateFlow
    private val _eventos = MutableStateFlow<List<Evento>>(emptyList())
    val eventos: StateFlow<List<Evento>> = _eventos

    init {
        fetchEventos()
    }

    fun fetchEventos() {
        viewModelScope.launch {
            try {
                val result = RetrofitFactory().getEventoService().listarPorUsuarioId(usuarioId)
                _eventos.value = result
            } catch (e: Exception) {
                print("Erro: ${e.message}")
            }
        }
    }
}
