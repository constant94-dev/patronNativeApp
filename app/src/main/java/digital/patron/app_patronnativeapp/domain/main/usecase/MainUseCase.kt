package digital.patron.app_patronnativeapp.domain.main.usecase

import android.app.Application
import digital.patron.app_patronnativeapp.data.common.RetrofitClient
import digital.patron.app_patronnativeapp.data.common.WrappedResponse
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainResponse
import digital.patron.app_patronnativeapp.data.main.repository.MainRepositoryImpl
import digital.patron.app_patronnativeapp.domain.common.BaseResult
import digital.patron.app_patronnativeapp.domain.main.MainRepository
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

class MainUseCase(
    private val application: Application,
    private val mainRepository: MainRepository = MainRepositoryImpl(application),
) {
    suspend fun execute(mainRequest: MainEntity): Flow<Call<MainEntity>> {
        return mainRepository.getMain(mainRequest)
    }
}