package digital.patron.app_patronnativeapp.data.repository

import android.util.Log
import digital.patron.app_patronnativeapp.data.network.model.NetworkHome
import digital.patron.app_patronnativeapp.data.network.model.NetworkHomeNewArtwork
import digital.patron.app_patronnativeapp.data.network.model.NetworkTest
import digital.patron.app_patronnativeapp.data.network.remote.HomeNetworkApi
import digital.patron.app_patronnativeapp.data.network.retrofit.RetrofitNetwork
import digital.patron.app_patronnativeapp.domain.dto.ExhibitionDto
import digital.patron.app_patronnativeapp.domain.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response


/**
 * 각 리포지토리에는 자체 모델이 있습니다.
 * 예를들어 TopicsRepository 에는 Topic 모델이 있고 NewRepository 에는 NewsResource 모델이 있습니다.
 * 리포지토리는 다른 계층에 대한 공개 API이며 앱 데이터에 액세스할 수 있는 유일한 방법을 제공 합니다.
 * 리포지토리는 일반적으로 데이터 읽기 및 쓰기를 위한 하나 이상의 방법을 제공합니다.
 */

class HomeContentsRepository {
    companion object {
        private val retrofit = RetrofitNetwork.getInstance()
        val apiService: HomeNetworkApi = retrofit.create(HomeNetworkApi::class.java)

        const val TAG = "HomeContentsRepository"
    }

    suspend fun getHomeContents(): ExhibitionDto {
        return apiService.getHomeContents()
    }

    suspend fun getTests(): NetworkTest {
        return apiService.getTests()
    }

    suspend fun getFlowTests(): Flow<NetworkTest> = flow {
        val latest = apiService.getFlowTests()
        emit(latest)
    }

}