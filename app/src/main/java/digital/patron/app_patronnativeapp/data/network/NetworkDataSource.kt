package digital.patron.app_patronnativeapp.data.network

import digital.patron.app_patronnativeapp.data.network.model.NetworkHome

/**
 * 백엔드에 대한 네트워크 호출을 나타내는 인터페이스
 * */
interface NetworkDataSource {
    suspend fun getHomeContents(ids: List<String>? = null): List<NetworkHome>
}