package digital.patron.app_patronnativeapp.data.network.retrofit

import digital.patron.app_patronnativeapp.data.network.NetworkDataSource
import digital.patron.app_patronnativeapp.data.network.model.NetworkHome
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton;


/*
* 백엔드 서버에서 REST API를 호출합니다.
* */
private interface RetrofitNetworkApi {
    @GET(value = "home")
    suspend fun getHomeContents(
        @Query("id") ids: List<String>?,
    ): NetworkResponse<List<NetworkHome>>
}

private const val BaseUrl = "http://20.249.92.52" // 백엔드 서버 IP

@Serializable
private data class NetworkResponse<T>(
    val data: T,
)

/*
* 백엔드 서버에서 네트워크 응답을 받습니다.
* */
@Singleton
class RetrofitNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory,
) : NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitNetworkApi::class.java)


    override suspend fun getHomeContents(ids: List<String>?): List<NetworkHome> =
        networkApi.getHomeContents(ids = ids).data


}