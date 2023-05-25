package digital.patron.app_patronnativeapp.domain.remote.repository

import digital.patron.app_patronnativeapp.domain.remote.model.User
import digital.patron.app_patronnativeapp.di.RetrofitClient

class UserRepository {
    suspend fun getUserName(userId: Int): User {
        return RetrofitClient.user_api.getUserName(userId)
    }
}