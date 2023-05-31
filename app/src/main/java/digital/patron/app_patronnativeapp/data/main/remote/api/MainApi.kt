package digital.patron.app_patronnativeapp.data.main.remote.api

import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MainApi {

    @POST("/home/main")
    suspend fun showMain(@Body mainRequest: MainEntity): Response<MainEntity>

    @POST("/home/main2")
    suspend fun listMain(@Body mainRequest2: MainEntity): List<MainEntity>
    /* 서버에서 응답할 때 단일 값이 아니라 MainEntity 형태로 반환해보자 */
}