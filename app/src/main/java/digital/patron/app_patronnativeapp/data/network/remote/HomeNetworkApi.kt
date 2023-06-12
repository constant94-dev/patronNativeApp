package digital.patron.app_patronnativeapp.data.network.remote

import digital.patron.app_patronnativeapp.data.network.model.NetworkHome
import digital.patron.app_patronnativeapp.data.network.model.NetworkTest
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * 백엔드 서버에서 REST API를 호출합니다.
 * */
interface HomeNetworkApi {
    @GET(value = "home")
    fun getHomeContents(): Flow<Response<NetworkHome>> // Flow는 Kotlin의 코루틴을 활용하여 비동기 스트림을 처리하는 기능

    @GET("/test")
    suspend fun getTests(): NetworkTest
}