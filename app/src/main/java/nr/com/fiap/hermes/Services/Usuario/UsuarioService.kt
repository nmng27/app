package nr.com.fiap.hermes.Services.Usuario

import androidx.room.Delete
import nr.com.fiap.hermes.Models.Usuario
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UsuarioService {
    @POST("/usuario/add")
    fun cadastrar(usuario: Usuario)

    @PUT("/usuario/upd/{id}")
    fun atualizar(usuario: Usuario, @Path("id") id:Int)

    @DELETE("/usuario/del/{id}")
    fun excluir(@Path("id") id:Int)

    @POST("/usuario/login/")
    fun login(email:String, senha:String)
}