package digital.patron.app_patronnativeapp.data.main.remote.source

import digital.patron.app_patronnativeapp.data.main.remote.api.MainApi
import retrofit2.Retrofit

class MainNetwork {

    fun provideMainApi(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi::class.java)
    }

}