package digital.patron.app_patronnativeapp.domain.main.usecase

import android.util.Log
import digital.patron.app_patronnativeapp.data.main.remote.repository.MainRepository
import digital.patron.app_patronnativeapp.domain.common.BaseResult
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class MainUseCase(
    private val mainRepository: MainRepository,
) {
    suspend fun execute(mainRequest: MainEntity): Flow<Response<MainEntity>> {
        Log.d("test2","test2")
        return mainRepository.showMain(mainRequest)
        /* map(), filter() 사용해서 데이터 가공을 진행할 수 있다.*/
    }
}