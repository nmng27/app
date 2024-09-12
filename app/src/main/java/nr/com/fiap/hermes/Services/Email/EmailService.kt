package nr.com.fiap.hermes.Services.Email

import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.Models.Usuario
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface EmailService {

    @POST("/emails/enviar")
    fun enviar(email: Email): Call<Email>

    @GET("/emails/listarPorUsuarioId/{usuarioId}")
    fun listarPorUsuarioId(@Path("usuarioId") usuarioId: Int): Call<List<Email>>

    @GET("/emails/listarPorCategoria/{categoria}/{usuarioId}")
    fun listarPorCategoria(@Path("categoria") categoria: String, @Path("usuarioId") usuarioId: Int): Call<List<Email>>

    @GET("/emails/buscarId/{id}")
    fun buscarId(@Path("id") id: Int): Call<Email>

    @DELETE
    fun deletar(@Path("id") id:Int):Call<Email>

    @PUT
    fun favoritar(id:Int):Call<Email>
}

