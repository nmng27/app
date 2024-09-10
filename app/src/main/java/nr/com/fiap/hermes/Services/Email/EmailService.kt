package nr.com.fiap.hermes.Services.Email

import nr.com.fiap.hermes.Models.Email
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EmailService {

    @POST("/emails/enviar")
    fun enviar(email: Email)


    @GET("/emails/listarPorUsuarioId/{usuarioId}")
    fun listarPorUsuarioId(@Path("usuarioId") usuarioId:Int)

    @GET("/emails/listarPorCategoriaAndUsuarioId/{categoria}/{usuarioId}")
    fun listarPorCategoria(@Path("categoria") categoria:String,@Path("usuarioId") usuario_id: Int)

    @GET("/buscarId/{id}")
    fun buscarId(@Path("id") id:Int)
}