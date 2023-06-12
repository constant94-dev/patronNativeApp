package digital.patron.app_patronnativeapp.ui.main

import android.app.Application
import android.net.Network
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import digital.patron.app_patronnativeapp.data.network.model.NetworkTest
import digital.patron.app_patronnativeapp.data.repository.HomeContentsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import digital.patron.app_patronnativeapp.domain.model.Result

class HomeViewModel(
    application: Application,
    private val homeContentsRepository: HomeContentsRepository,
) : AndroidViewModel(application) {
    private val _data = MutableStateFlow(NetworkTest(""))
    val data: StateFlow<NetworkTest> = _data.asStateFlow()

    companion object {
        const val TAG = "HomeViewModel"
    }

    fun getNetworkTest(): Flow<Result<NetworkTest>> = flow {
        kotlin.runCatching {
            Log.d(TAG, "서버 통신 Flow 로 성공했어!!!!!!!!!!!!!!!!")
            val result: NetworkTest = homeContentsRepository.getTests()
            emit(Result.Success(result))
        }.onFailure { throwable ->
            Log.e(TAG, "서버 통신 Flow 로 실패했어!!!!!!!!!!!!!!!!!!", throwable)
            emit(Result.Failure(throwable))
        }
    }
}