package digital.patron.app_patronnativeapp.data.main.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import digital.patron.app_patronnativeapp.data.common.RetrofitClient
import digital.patron.app_patronnativeapp.data.main.remote.api.MainApi
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainResponse
import digital.patron.app_patronnativeapp.domain.common.BaseResult
import digital.patron.app_patronnativeapp.domain.main.MainRepository
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MainRepositoryImpl(private val mainApi: MainApi) : MainRepository {
    private val client = RetrofitClient.getInstance().create(MainApi::class.java)

    override suspend fun getMain(mainRequest: MainRequest): Flow<BaseResult<MainEntity, Response<MainResponse>>> {

        return client.showMain(mainRequest)
    }

}