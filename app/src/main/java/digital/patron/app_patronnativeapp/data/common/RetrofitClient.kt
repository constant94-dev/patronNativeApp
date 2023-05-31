package digital.patron.app_patronnativeapp.data.common

import com.google.gson.GsonBuilder
import com.google.gson.InstanceCreator
import digital.patron.app_patronnativeapp.data.main.remote.api.MainApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

object RetrofitClient {
    val gson = GsonBuilder()
        .registerTypeAdapter(Flow::class.java, FlowInstanceCreator())
        .create()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val main: MainApi by lazy {
        retrofit.create(MainApi::class.java)
    }
}

class FlowInstanceCreator : InstanceCreator<Flow<*>> {
    override fun createInstance(type: Type?): Flow<*> {
        return flowOf<Response<*>>()
    }

}