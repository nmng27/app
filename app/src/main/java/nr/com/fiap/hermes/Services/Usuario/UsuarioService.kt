package nr.com.fiap.hermes.Services.Usuario

import nr.com.fiap.hermes.Models.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UsuarioService {
    @POST("/usuario/add")
    fun cadastrar(@Body usuario: Usuario): Call<Usuario>

    @PUT("/usuario/upd/{id}")
    fun atualizar(@Body usuario: Usuario, @Path("id") id: Int): Call<Void>

    @DELETE("/usuario/del/{id}")
    fun excluir(@Path("id") id: Int): Call<Void>

    @POST("/usuario/login/")
    fun login(@Body email:String,senha:String): Call<Usuario>
}
