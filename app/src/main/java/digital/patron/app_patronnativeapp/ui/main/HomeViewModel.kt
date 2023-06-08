package digital.patron.app_patronnativeapp.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import digital.patron.app_patronnativeapp.domain.usecase.HomeResourcesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    application: Application,
    private val homeResourcesUseCase: HomeResourcesUseCase,
) : AndroidViewModel(application) {

    // '홈 콘텐츠 불러오기' 기능
    fun getHomeContents(){
        viewModelScope.launch {
            homeResourcesUseCase.getHomeContents()
        }
    }

}