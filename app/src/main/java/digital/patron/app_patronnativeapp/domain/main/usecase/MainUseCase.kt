package digital.patron.app_patronnativeapp.domain.main.usecase

import android.app.Application
import digital.patron.app_patronnativeapp.data.main.remote.api.MainRepository
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class MainUseCase(
    private val mainRepository: MainRepository,
) {
    suspend fun execute(mainRequest: MainEntity): Flow<Response<MainEntity>> {
        return mainRepository.showMain(mainRequest)
        /* map(), filter() 사용해서 데이터 가공을 진행할 수 있다.*/
    }
}