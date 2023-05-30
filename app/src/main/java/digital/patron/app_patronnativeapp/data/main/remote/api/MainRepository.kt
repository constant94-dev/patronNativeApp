package digital.patron.app_patronnativeapp.data.main.remote.api

import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MainRepository {
    @POST("/home/main")
    suspend fun showMain(@Body mainRequest: MainEntity): Flow<Response<MainEntity>>

}