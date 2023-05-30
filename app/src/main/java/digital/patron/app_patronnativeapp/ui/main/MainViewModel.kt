package digital.patron.app_patronnativeapp.ui.main

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainResponse
import digital.patron.app_patronnativeapp.domain.common.BaseResult
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import digital.patron.app_patronnativeapp.domain.main.usecase.MainUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    private val application: Application,
    private val mainUseCase: MainUseCase,
) : AndroidViewModel(application) {

    private val _state = MutableStateFlow<List<MainEntity>>(emptyList())
    val state: StateFlow<List<MainEntity>> = _state.asStateFlow()

    fun test(mainRequest: MainEntity) {
        viewModelScope.launch {
            mainUseCase.execute(mainRequest)
                .collect { result ->
                    print(result)

                }
        }
    }
}