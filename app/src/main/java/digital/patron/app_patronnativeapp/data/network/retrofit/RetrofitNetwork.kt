package digital.patron.app_patronnativeapp.data.network.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import digital.patron.app_patronnativeapp.data.network.remote.HomeNetworkApi
import digital.patron.app_patronnativeapp.data.repository.HomeContentsRepository
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit을 사용하여 Remote API 통신을 위한 싱글톤 Retrofit 인스턴스를 생성하는 데 사용
 * */
object RetrofitNetwork {
    //private const val BaseUrl = "http://20.249.92.52:8088/" //  API 요청의 기본 URL
    private const val BaseUrl = "http://211.217.233.136:8088/"

    private val okHttpClient: OkHttpClient by lazy {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()// 로깅 인터셉터가 추가되어 로그를 출력할 수 있도록 설정
    } //  HTTP 통신을 위한 OkHttp 클라이언트를 생성

    private val networkGson: Gson by lazy {
        GsonBuilder()
            .setLenient()
            .create()
    } //  Gson은 JSON 데이터의 직렬화 및 역직렬화를 처리하는 데 사용

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(networkGson))
            .build()
    }
}