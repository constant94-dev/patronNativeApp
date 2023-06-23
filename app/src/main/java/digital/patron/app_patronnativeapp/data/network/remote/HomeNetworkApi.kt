package digital.patron.app_patronnativeapp.data.network.remote

import digital.patron.app_patronnativeapp.data.network.model.NetworkHome
import digital.patron.app_patronnativeapp.data.network.model.NetworkHomeNewArtwork
import digital.patron.app_patronnativeapp.data.network.model.NetworkTest
import digital.patron.app_patronnativeapp.domain.dto.ExhibitionDto
import digital.patron.app_patronnativeapp.domain.model.Result
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
    suspend fun getHomeContents(): ExhibitionDto

    @GET("/test")
    suspend fun getTests(): NetworkTest

    @GET("/test")
    suspend fun getFlowTests(): NetworkTest
}