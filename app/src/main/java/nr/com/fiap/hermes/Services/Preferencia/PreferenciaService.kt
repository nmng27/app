package nr.com.fiap.hermes.Services.Preferencia

import nr.com.fiap.hermes.Models.Preferencias
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PreferenciaService {
    @POST("/preferencias/add")
    fun add(preferencias: Preferencias): Call<Preferencias>

    @PUT("/preferencias/atualizar/{id}/{tema}")
    fun upd(@Path("id") id: Int, @Path("tema") tema:String): Call<Preferencias>

    @DELETE("/preferencias/deletar/{id}")
    fun delete(@Path("id") id: Int): Call<Void>

    @GET("/preferencias/buscarPorId/{id}")
    fun buscarPorId(@Path("id") id: Int): Call<Preferencias>

    @GET("/preferencias/listarPorUsuarioId/{usuarioId}")
    fun listarPorUsuarioId(@Path("usuarioId") usuarioId: Int): Call<List<Preferencias>>
}
