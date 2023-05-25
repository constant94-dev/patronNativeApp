package digital.patron.app_patronnativeapp.data.remote.source

import digital.patron.app_patronnativeapp.domain.remote.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/user/{userid}")
    suspend fun getUserName(@Path("userid") userId: Int): User
}