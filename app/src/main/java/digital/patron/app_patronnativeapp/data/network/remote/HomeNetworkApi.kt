package digital.patron.app_patronnativeapp.data.network.remote

import digital.patron.app_patronnativeapp.data.network.model.NetworkHome
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * 백엔드 서버에서 REST API를 호출합니다.
 * */
interface HomeNetworkApi {

    @GET("api/endpoint")
    fun getHomeContents(): Flow<NetworkHome> // Flow는 Kotlin의 코루틴을 활용하여 비동기 스트림을 처리하는 기능

}
