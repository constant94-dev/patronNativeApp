package digital.patron.app_patronnativeapp.domain.usecase

import digital.patron.app_patronnativeapp.data.network.model.NetworkHome

import digital.patron.app_patronnativeapp.data.repository.HomeContentsRepository
import digital.patron.app_patronnativeapp.domain.model.ThemeResult
import kotlinx.coroutines.flow.Flow

class HomeResourcesUseCase(
    private val homeContentsRepository: HomeContentsRepository,
) {
    suspend fun getHomeContents(): Flow<NetworkHome> {
        val responseFlow = homeContentsRepository.getHomeContents()
        try {
            responseFlow.collect { response ->
                // 응답 데이터 처리
                ThemeResult(
                    theme1 = response.theme1,
                    theme2 = response.theme2,
                    theme3 = response.theme3,
                    theme4 = response.theme4,
                    theme5 = response.theme5,
                    theme1DurationTime = response.theme1DurationTime,
                    theme2DurationTime = response.theme2DurationTime,
                    theme3DurationTime = response.theme3DurationTime,
                    theme4DurationTime = response.theme4DurationTime,
                    theme5DurationTime = response.theme5DurationTime,
                )
            }
        } catch (e: Exception) {
            // 네트워크 오류 등 예외 처리
            e.printStackTrace()
        }
        return responseFlow
    }
}