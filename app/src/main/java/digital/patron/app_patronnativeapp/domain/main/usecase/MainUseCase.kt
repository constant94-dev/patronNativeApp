package digital.patron.app_patronnativeapp.domain.main.usecase

import digital.patron.app_patronnativeapp.data.common.RetrofitClient
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainResponse
import digital.patron.app_patronnativeapp.domain.common.BaseResult
import digital.patron.app_patronnativeapp.domain.main.MainRepository
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class MainUseCase {
    private var mainRepository: MainRepository? = null


    constructor()

    constructor(mainRepository: MainRepository){
        this.mainRepository = mainRepository
    }

    suspend fun execute(mainRequest: MainRequest): Flow<BaseResult<MainEntity, Response<MainResponse>>> {
        return mainRepository?.let { it ->
            mainRepository.getMain(mainRequest)
        }
    }
}