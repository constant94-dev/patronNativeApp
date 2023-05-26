package digital.patron.app_patronnativeapp.ui.main

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.domain.main.usecase.MainUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application,
) : AndroidViewModel(application) {

    private val mainUseCase: MainUseCase = TODO()
    private val mainRequest: MainRequest
    private val _state = MutableStateFlow<List<MainViewModel>>(emptyList())
    val state: StateFlow<List<MainViewModel>> = _state.asStateFlow()

    suspend fun test() {
        viewModelScope.launch {
            mainUseCase.execute(mainRequest)
        }

    }
}