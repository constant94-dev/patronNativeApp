package digital.patron.app_patronnativeapp.domain.remote.repository

interface UserRepository {

    fun getUserAll() // '사용자' 전체 정보 조회
    fun getUserName() // '사용자' 이름 조회
}