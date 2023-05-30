package digital.patron.app_patronnativeapp.domain.main

import digital.patron.app_patronnativeapp.data.common.WrappedResponse
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainResponse
import digital.patron.app_patronnativeapp.domain.common.BaseResult
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

interface MainRepository {
    suspend fun getMain(mainRequest: MainEntity): Flow<Call<MainEntity>>

}