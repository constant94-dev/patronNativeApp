package digital.patron.app_patronnativeapp.data.network.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
* Retrofit을 사용하여 Remote API 통신을 위한 싱글톤 Retrofit 인스턴스를 생성하는 데 사용
* */
object RetrofitNetwork {
    const val BaseUrl = "https://api.example.com/" //  API 요청의 기본 URL

    private var retrofitInstance: Retrofit? = null // Retrofit 인스턴스 초기화
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
        if (retrofitInstance == null) {
            synchronized(this) {
                if (retrofitInstance == null) {
                    retrofitInstance = Retrofit.Builder()
                        .baseUrl(BaseUrl)
                        .callFactory(okHttpClient)
                        .addConverterFactory(
                            GsonConverterFactory.create(networkGson)
                        )
                        .build()
                }
            } // 인스턴스가 아직 생성되지 않았으면 synchronized 블록 내에서 Retrofit을 구성하고 생성
        }
        return retrofitInstance!!
    } // 싱글톤 Retrofit 인스턴스를 반환
}