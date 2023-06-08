package digital.patron.app_patronnativeapp.data.network

import digital.patron.app_patronnativeapp.data.network.model.NetworkHome

/**
 * 백엔드에 대한 네트워크 호출을 나타내는 인터페이스
 * 리포지토리는 하나 이상의 데이터 소스에 의존할 수 있습니다.
 * 데이터는 REST API 엔드포인트를 통해 JSON 으로 제공됩니다.
 * 원격 서버 데이터베이스에서 가져온 데이터를 로컬 데이터베이스와 동기화할 때 사용할 예정
 * */
interface NetworkDataSource {
//    suspend fun getHomeContents(ids: List<String>? = null): List<NetworkHome>
}