package nr.com.fiap.hermes.Models.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import nr.com.fiap.hermes.Models.Usuario

@Dao
interface UsuarioDao {
    @Insert
    fun cadastrar(usuario: Usuario)

    @Update
    fun atualizar(usuario: Usuario,id:Int)

    @Delete
    fun deletar(id: Int)

    @Query("SELECT * FROM USUARIOS WHERE EMAIL = :email AND SENHA = :senha")
    fun login(email:String,senha:String)

}