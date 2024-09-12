package nr.com.fiap.hermes.Services.Evento

import nr.com.fiap.hermes.Models.Evento
import nr.com.fiap.hermes.Models.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface EventoService {
    @POST("/eventos/add")
    fun add(@Body evento: Evento): Call<Evento>

    @PUT("/eventos/upd/{id}")
    fun upd(evento: Evento,@Path("id") id:Int):Call<Void>

    @DELETE("/eventos/deletar/{id}")
    fun del(@Path("id") id:Int):Call<Void>

    @GET("/eventos/listarPorId/{id}")
    fun buscarPorId(@Path("id") id:Int):Call<Evento>


    @GET("/evento/listarPorUsuario/{usuarioId}")
    fun listarPorUsuarioId(@Path("usuarioId") usuarioId:Int):Call<List<Evento>>
}