package digital.patron.app_patronnativeapp.ui.setting

import android.app.Application
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import digital.patron.app_patronnativeapp.data.repository.SettingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingViewModel(
    application: Application,
    private val settingRepository: SettingRepository,
): AndroidViewModel(application) {

    companion object {
        const val TAG = "SettingViewModel"
    }
    fun logout(){
        viewModelScope.launch {
            val response = settingRepository.logout()

        }
    }

    fun webSiteMove(){
        viewModelScope.launch {
        }
    }
}