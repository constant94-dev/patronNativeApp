package digital.patron.app_patronnativeapp.domain.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import digital.patron.app_patronnativeapp.data.repository.SettingRepository
import digital.patron.app_patronnativeapp.ui.setting.SettingViewModel

class SettingAndroidViewModelFactory(
    private val application: Application,
) : ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingViewModel::class.java)) {
            return SettingViewModel(
                application = application,
                settingRepository = SettingRepository()
            ) as T
        }
        return super.create(modelClass) // 위 경우를 제외하면 일반적인 기능으로 제공하겠다
    }
}