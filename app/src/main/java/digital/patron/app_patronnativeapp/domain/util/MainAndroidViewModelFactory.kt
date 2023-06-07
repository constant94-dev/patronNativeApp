package digital.patron.app_patronnativeapp.domain.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import digital.patron.app_patronnativeapp.ui.main.MainViewModel

/*
* 특정 상황에서 내가 원하는 ViewModel 을 사용하려면 이러한 Factory 클래스를 별도로 만들어야 한다
* */
class MainAndroidViewModelFactory(
    private val application: Application,
) : ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // 'MainViewModel' 을 만드는 경우 어떤 작업을 해줄 것인가
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application) as T
        }
        return super.create(modelClass) // 위 경우를 제외하면 일반적인 기능으로 제공하겠다
    }
}