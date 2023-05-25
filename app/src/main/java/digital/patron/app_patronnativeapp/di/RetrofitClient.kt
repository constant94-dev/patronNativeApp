package digital.patron.app_patronnativeapp.di

import digital.patron.app_patronnativeapp.data.remote.source.ArtworkApi
import digital.patron.app_patronnativeapp.data.remote.source.UserApi
import digital.patron.app_patronnativeapp.di.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* 싱글톤으로 객체를 생성
* */
object RetrofitClient {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val user_api: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

    val artwork_api: ArtworkApi by lazy {
        retrofit.create(ArtworkApi::class.java)
    }
}