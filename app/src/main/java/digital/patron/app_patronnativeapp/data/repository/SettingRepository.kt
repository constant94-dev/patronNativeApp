package digital.patron.app_patronnativeapp.data.repository

import digital.patron.app_patronnativeapp.data.network.remote.HomeNetworkApi
import digital.patron.app_patronnativeapp.data.network.remote.SettingNetworkApi
import digital.patron.app_patronnativeapp.data.network.retrofit.RetrofitNetwork
import digital.patron.app_patronnativeapp.domain.dto.SettingLogoutDto

class SettingRepository {

    companion object {
        private val retrofit = RetrofitNetwork.getInstance()
        val apiService: SettingNetworkApi = retrofit.create(SettingNetworkApi::class.java)

        const val TAG = "SettingRepository"
    }

    suspend fun logout(): SettingLogoutDto {
        return apiService.logout()
    }

}