package digital.patron.app_patronnativeapp.data.network.remote

import digital.patron.app_patronnativeapp.domain.dto.SettingLogoutDto
import retrofit2.http.GET

interface SettingNetworkApi {

    @GET("/logout")
    suspend fun logout(): SettingLogoutDto
}