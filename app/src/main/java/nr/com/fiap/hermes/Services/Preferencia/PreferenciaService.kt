package nr.com.fiap.hermes.Services.Preferencia

import nr.com.fiap.hermes.Models.Preferencias
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PreferenciaService {
    @POST("/preferencias/add")
    fun add(preferencias: Preferencias)

    @PUT("/preferencias/atualizar/{id}")
    fun upd(@Path("id") id:Int, preferencias: Preferencias)

    @DELETE("/preferencias/deletar/{id}")
    fun delete(@Path("id") id:Int)

    @GET("/preferencias/buscarPorId/{id}")
    fun buscarId(@Path("id")id: Int)

    @GET("/preferencias/listarPorUsuarioId/{usuarioId}")
    fun listarPorUsuarioId(@Path("usuarioId") usuarioId:Int)
}