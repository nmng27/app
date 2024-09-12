package nr.com.fiap.hermes.Services.Email

import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Models.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EmailService {

    @POST("/emails/enviar")
    fun enviar(email: Email): Call<Usuario>


    @GET("/emails/listarPorUsuarioId/{usuarioId}")
    fun listarPorUsuarioId(@Path("usuarioId") usuarioId:Int):List<Email>

    @GET("/emails/listarPorCategoria/{categoria}/{usuarioId}")
    fun listarPorCategoria(@Path("categoria") categoria:String,@Path("usuarioId") usuario_id: Int):List<Email>

    @GET("/emails/buscarId/{id}")
    fun buscarId(@Path("id") id:Int):Call<Usuario>
}