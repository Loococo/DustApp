package app.loococo.data.remote.api

import app.loococo.data.model.DustResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DustApi {
    @GET("getCtprvnRltmMesureDnsty")
    suspend fun dustInfo(
        @Query("returnType") returnType: String,
        @Query("sidoName") sidoName: String,
        @Query("numOfRows") numOfRows: Int
    ): Response<DustResponse>
}