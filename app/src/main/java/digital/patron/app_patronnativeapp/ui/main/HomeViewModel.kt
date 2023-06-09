package digital.patron.app_patronnativeapp.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import digital.patron.app_patronnativeapp.data.repository.HomeContentsRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    application: Application,
    private val homeContentsRepository: HomeContentsRepository,
) : AndroidViewModel(application) {

    // '홈 콘텐츠 불러오기' 기능
    fun getHomeContents() {
        Log.d("HomeViewModel: ", "홈 콘텐츠 불러오기 기능 실행합니다.")
        viewModelScope.launch {
            var response = homeContentsRepository.getHomeContents()
            response.collect {
                Log.d("Dddddddddd", it.body().toString())
            }
        }



    }

}