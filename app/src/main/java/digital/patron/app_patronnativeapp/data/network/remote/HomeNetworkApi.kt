package digital.patron.app_patronnativeapp.data.network.remote

import digital.patron.app_patronnativeapp.data.network.model.NetworkTest
import digital.patron.app_patronnativeapp.domain.dto.HomeContentsDto
import retrofit2.http.GET

/**
 * 백엔드 서버에서 REST API를 호출합니다.
 * */
interface HomeNetworkApi {
    @GET(value = "home")
    suspend fun getHomeContents(): HomeContentsDto

    @GET("/test")
    suspend fun getTests(): NetworkTest

    @GET("/test")
    suspend fun getFlowTests(): NetworkTest
}