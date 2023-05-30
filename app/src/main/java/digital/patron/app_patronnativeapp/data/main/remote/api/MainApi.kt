package digital.patron.app_patronnativeapp.data.main.remote.api

import digital.patron.app_patronnativeapp.data.common.WrappedResponse
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainResponse
import digital.patron.app_patronnativeapp.domain.common.BaseResult
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MainApi {
    @POST("/home/main")
    suspend fun showMain(@Body mainRequest: MainEntity): Call<MainEntity>
}