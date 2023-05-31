package digital.patron.app_patronnativeapp.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope

import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import digital.patron.app_patronnativeapp.domain.main.usecase.MainUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect

import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(
    application: Application,
    private val mainUseCase: MainUseCase,
) : AndroidViewModel(application) {

    private val _state = MutableStateFlow<List<MainEntity>>(emptyList())
    val state: StateFlow<List<MainEntity>> = _state.asStateFlow()

    private val _state2 = MutableStateFlow<MainEntity>(MainEntity(""))
    val state2: StateFlow<MainEntity> = _state2

    fun test(testRequest: MainEntity) {
        Log.d("test1", "test1")
        viewModelScope.launch {
            mainUseCase.execute(testRequest)
                .collect { result ->
                    Log.d("result", result.body().toString())
                    result.body()?.let {
                        Log.d("result2", it.code)

                        _state2.value = it

                        Log.d("result3", _state2.value.code)
                        Log.d("result4", _state2.value.toString())
                    }

                }
        }
    }
}