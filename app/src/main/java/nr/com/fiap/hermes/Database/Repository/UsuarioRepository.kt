package nr.com.fiap.hermes.Database.Repository

import android.content.Context // Importação correta
import nr.com.fiap.hermes.Database.config.UsuarioDb
import nr.com.fiap.hermes.Models.Usuario

class UsuarioRepository(context: Context) {
    private val db = UsuarioDb.getDatabase(context).usuarioDao()

    fun cadastrar(usuario: Usuario) {
        db.cadastrar(usuario)
    }

    fun atualizar(usuario: Usuario, id: Int) {
        db.atualizar(usuario, id)
    }

    fun deletar(id: Int) {
        db.deletar(id)
    }

    fun logar(email: String, senha: String) {
        db.login(email, senha)
    }
}
