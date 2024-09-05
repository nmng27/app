package nr.com.fiap.hermes.Database.Repository

import android.content.Context // Importação correta
import nr.com.fiap.hermes.Database.config.UsuarioDb
import nr.com.fiap.hermes.Models.Usuario

class UsuarioRepository(context: Context) {
    private val db = UsuarioDb.getDatabase(context).usuarioDao()

    fun cadastrar(usuario: Usuario):Long {
        return db.cadastrar(usuario)
    }

    fun atualizar(usuario: Usuario, id: Int):Int {
        return db.atualizar(usuario)
    }

    fun deletar(usuario: Usuario):Int {
        return db.deletar(usuario)
    }

    fun logar(email: String, senha: String):Usuario {
        return db.login(email, senha)
    }
}
