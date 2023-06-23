package digital.patron.app_patronnativeapp.ui.main

import android.app.Application
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import digital.patron.app_patronnativeapp.data.network.model.NetworkTest
import digital.patron.app_patronnativeapp.data.repository.HomeContentsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
//import digital.patron.app_patronnativeapp.domain.model.Result
import kotlinx.coroutines.launch

class HomeViewModel(
    application: Application,
    private val homeContentsRepository: HomeContentsRepository,
) : AndroidViewModel(application) {
    private val _dataFlow = MutableStateFlow("")
    val dataFlow: StateFlow<String> = _dataFlow

    private val _data = mutableStateOf<String>("")
    val data: State<String> = _data

    private val _curationThumb = mutableStateOf<List<String>>(emptyList())
    val curationThumb: State<List<String>> = _curationThumb

    private val _curationThumbName = mutableStateOf<List<String>>(emptyList())
    val curationThumbName: State<List<String>> = _curationThumbName
    
    private val _curationArtistName = mutableStateOf<List<String>>(emptyList())
    val curationArtistName: State<List<String>> = _curationArtistName

    private val _curationArtistCount = mutableStateOf<List<Integer>>(emptyList())
    val curationArtistCount: State<List<Integer>> = _curationArtistCount

    private val _newlyArtworks = mutableStateOf<List<String>>(emptyList())
    val newlyArtworks: State<List<String>> = _newlyArtworks

    private val _artistProfileImage = mutableStateOf<List<String>>(emptyList())
    val artistProfileImage: State<List<String>> = _artistProfileImage

    private val _recommendArtistName = mutableStateOf<List<String>>(emptyList())
    val recommendArtistName: State<List<String>> = _recommendArtistName

    companion object {
        const val TAG = "HomeViewModel"
    }

    init {
        getHomeContents()
    }

    // State 활용한 홈 콘텐츠 가져오기
    private fun getHomeContents() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = homeContentsRepository.getHomeContents()
            Log.d(TAG, "getHomeContents all: ${response.toString()}")
            _curationThumb.value = response.curationThumbnail
            _curationThumbName.value = response.curationThumbName
            _curationArtistName.value = response.curationArtistName
            _curationArtistCount.value = response.curationArtistCount
            _newlyArtworks.value = response.newlyArtworks
            _artistProfileImage.value = response.artistProfileImage
            _recommendArtistName.value = response.recommendArtistName
        }
    }

    // State 활용한 네트워크 요청
    fun getNetworkTest() {
        viewModelScope.launch(Dispatchers.IO) {
            val result: NetworkTest = homeContentsRepository.getTests()
            _data.value = result.title
            Log.d(TAG, "getNetworkTest: ${result.title}")
        }
    }

    // StateFlow 활용한 네트워크 요청
    fun getNetworkFlowTest() {
        viewModelScope.launch(Dispatchers.IO) {
            homeContentsRepository.getFlowTests()
                .collect { it ->
                    _dataFlow.value = it.title
                    Log.d(TAG, "getNetworkFlowTest: ${it.title}")
                }
        }
    }
}