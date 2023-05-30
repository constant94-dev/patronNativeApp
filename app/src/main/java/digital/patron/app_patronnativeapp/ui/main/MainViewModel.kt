package digital.patron.app_patronnativeapp.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope

import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import digital.patron.app_patronnativeapp.domain.main.usecase.MainUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch


class MainViewModel(
    application: Application,
    private val mainUseCase: MainUseCase,
) : AndroidViewModel(application) {

    private val _state = MutableStateFlow<List<MainEntity>>(emptyList())
    val state: StateFlow<List<MainEntity>> = _state.asStateFlow()

    private val _state2 = MutableStateFlow<MainEntity>(MainEntity(""))
    val state2: StateFlow<MainEntity> = _state2

    fun test(mainRequest: MainEntity) {
        viewModelScope.launch {
            mainUseCase.execute(mainRequest)
                .collect { result ->
                    if (result.isSuccessful) {
                        /* 엘비스 연산자 */
                        _state2.value = MainEntity(result.body()?.code ?: "")
                    }


                }
        }
    }
}