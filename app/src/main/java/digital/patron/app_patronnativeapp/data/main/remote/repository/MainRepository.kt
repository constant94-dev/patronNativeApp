package digital.patron.app_patronnativeapp.data.main.remote.repository

import digital.patron.app_patronnativeapp.data.common.RetrofitClient
import digital.patron.app_patronnativeapp.domain.common.BaseResult
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.lang.Error

class MainRepository {
    private val mainClient = RetrofitClient.main

    suspend fun showMain(mainRequest: MainEntity): Flow<Response<MainEntity>> {
        return flow {
            val result = mainClient.showMain(mainRequest)
            if (result.isSuccessful) {
                emit(result)
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun fetchMain(mainRequest: MainEntity): BaseResult<Any, Any> {
        return getResponse(
            request = { mainClient.showMain(mainRequest) },
            defaultErrorMessage = "Error fetching Main list"
        )
    }

    private suspend fun <T : Any> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): BaseResult<Any, Any> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                return BaseResult.Success(result.body())
            } else {
                BaseResult.Error(result.errorBody() ?: defaultErrorMessage)
            }
        } catch (e: Throwable) {
            BaseResult.Error("Unknown Error")
        }
    }

}