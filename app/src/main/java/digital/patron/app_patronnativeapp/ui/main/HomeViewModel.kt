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

    private val _curationArtworkTitle = mutableStateOf<List<String>>(emptyList())
    val curationArtworkTitle: State<List<String>> = _curationArtworkTitle

    private val _curationArtistName = mutableStateOf<List<String>>(emptyList())
    val curationArtistName: State<List<String>> = _curationArtistName

    private val _curationArtistCount = mutableStateOf<List<Integer>>(emptyList())
    val curationArtistCount: State<List<Integer>> = _curationArtistCount

    private val _waitingThumbnail = mutableStateOf<List<String>>(emptyList())
    val waitingThumbnail: State<List<String>> = _waitingThumbnail

    private val _waitingThumbArtworkTitle = mutableStateOf<List<String>>(emptyList())
    val waitingThumbArtworkTitle: State<List<String>> = _waitingThumbArtworkTitle

    private val _waitingArtistName = mutableStateOf<List<String>>(emptyList())
    val waitingArtistName: State<List<String>> = _waitingArtistName

    private val _waitingArtistCount = mutableStateOf<List<Integer>>(emptyList())
    val waitingArtistCount: State<List<Integer>> = _waitingArtistCount

    private val _newlyArtworks = mutableStateOf<List<String>>(emptyList())
    val newlyArtworks: State<List<String>> = _newlyArtworks

    private val _artistProfileImage = mutableStateOf<List<String>>(emptyList())
    val artistProfileImage: State<List<String>> = _artistProfileImage

    private val _artistNameRecommend = mutableStateOf<List<String>>(emptyList())
    val artistNameRecommend: State<List<String>> = _artistNameRecommend

    private val _theme1ExhibitionTitle = mutableStateOf<String>("")
    val theme1ExhibitionTitle: State<String> = _theme1ExhibitionTitle

    private val _theme1Thumbnail = mutableStateOf<List<String>>(emptyList())
    val theme1Thumbnail: State<List<String>> = _theme1Thumbnail

    private val _theme1ThumbArtworkTitle = mutableStateOf<List<String>>(emptyList())
    val theme1ThumbArtworkTitle: State<List<String>> = _theme1ThumbArtworkTitle

    private val _theme1ThumbArtistTitle = mutableStateOf<List<String>>(emptyList())
    val theme1ThumbArtistTitle: State<List<String>> = _theme1ThumbArtistTitle

    private val _theme2ExhibitionTitle = mutableStateOf<String>("")
    val theme2ExhibitionTitle: State<String> = _theme2ExhibitionTitle

    private val _theme2Thumbnail = mutableStateOf<List<String>>(emptyList())
    val theme2Thumbnail: State<List<String>> = _theme2Thumbnail

    private val _theme2ThumbArtworkTitle = mutableStateOf<List<String>>(emptyList())
    val theme2ThumbArtworkTitle: State<List<String>> = _theme2ThumbArtworkTitle

    private val _theme2ThumbArtistTitle = mutableStateOf<List<String>>(emptyList())
    val theme2ThumbArtistTitle: State<List<String>> = _theme2ThumbArtistTitle

    private val _theme3ExhibitionTitle = mutableStateOf<String>("")
    val theme3ExhibitionTitle: State<String> = _theme3ExhibitionTitle

    private val _theme3Thumbnail = mutableStateOf<List<String>>(emptyList())
    val theme3Thumbnail: State<List<String>> = _theme3Thumbnail

    private val _theme3ThumbArtworkTitle = mutableStateOf<List<String>>(emptyList())
    val theme3ThumbArtworkTitle: State<List<String>> = _theme3ThumbArtworkTitle

    private val _theme3ThumbArtistTitle = mutableStateOf<List<String>>(emptyList())
    val theme3ThumbArtistTitle: State<List<String>> = _theme3ThumbArtistTitle

    private val _theme4ExhibitionTitle = mutableStateOf<String>("")
    val theme4ExhibitionTitle: State<String> = _theme4ExhibitionTitle

    private val _theme4Thumbnail = mutableStateOf<List<String>>(emptyList())
    val theme4Thumbnail: State<List<String>> = _theme4Thumbnail

    private val _theme4ThumbArtworkTitle = mutableStateOf<List<String>>(emptyList())
    val theme4ThumbArtworkTitle: State<List<String>> = _theme4ThumbArtworkTitle

    private val _theme4ThumbArtistTitle = mutableStateOf<List<String>>(emptyList())
    val theme4ThumbArtistTitle: State<List<String>> = _theme4ThumbArtistTitle

    private val _theme5ExhibitionTitle = mutableStateOf<String>("")
    val theme5ExhibitionTitle: State<String> = _theme5ExhibitionTitle

    private val _theme5Thumbnail = mutableStateOf<List<String>>(emptyList())
    val theme5Thumbnail: State<List<String>> = _theme5Thumbnail

    private val _theme5ThumbArtworkTitle = mutableStateOf<List<String>>(emptyList())
    val theme5ThumbArtworkTitle: State<List<String>> = _theme5ThumbArtworkTitle

    private val _theme5ThumbArtistTitle = mutableStateOf<List<String>>(emptyList())
    val theme5ThumbArtistTitle: State<List<String>> = _theme5ThumbArtistTitle

    companion object {
        const val TAG = "HomeViewModel"
    }

    init {
        //getHomeContents()
    }

    // State 활용한 홈 콘텐츠 가져오기
    private fun getHomeContents() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = homeContentsRepository.getHomeContents()

            _curationThumb.value = response.curationThumbnail
            _curationArtworkTitle.value = response.curationThumbArtworkTitle
            _curationArtistName.value = response.curationArtistName
            _curationArtistCount.value = response.curationArtistCount

            _waitingThumbnail.value = response.waitingThumbnail
            _waitingThumbArtworkTitle.value = response.waitingThumbArtworkTitle
            _waitingArtistName.value = response.waitingArtistName
            _waitingArtistCount.value = response.waitingArtistCount

            _newlyArtworks.value = response.newlyArtworks

            _theme1ExhibitionTitle.value = response.theme1ExhibitionTitle
            _theme1Thumbnail.value = response.theme1Thumbnail
            _theme1ThumbArtworkTitle.value = response.theme1ThumbArtworkTitle
            _theme1ThumbArtistTitle.value = response.theme1ThumbArtistTitle

            _theme2ExhibitionTitle.value = response.theme2ExhibitionTitle
            _theme2Thumbnail.value = response.theme2Thumbnail
            _theme2ThumbArtworkTitle.value = response.theme2ThumbArtworkTitle
            _theme2ThumbArtistTitle.value = response.theme2ThumbArtistTitle

            _theme3ExhibitionTitle.value = response.theme3ExhibitionTitle
            _theme3Thumbnail.value = response.theme3Thumbnail
            _theme3ThumbArtworkTitle.value = response.theme3ThumbArtworkTitle
            _theme3ThumbArtistTitle.value = response.theme3ThumbArtistTitle

            _theme4ExhibitionTitle.value = response.theme4ExhibitionTitle
            _theme4Thumbnail.value = response.theme4Thumbnail
            _theme4ThumbArtworkTitle.value = response.theme4ThumbArtworkTitle
            _theme4ThumbArtistTitle.value = response.theme4ThumbArtistTitle

            _theme5ExhibitionTitle.value = response.theme5ExhibitionTitle
            _theme5Thumbnail.value = response.theme5Thumbnail
            _theme5ThumbArtworkTitle.value = response.theme5ThumbArtworkTitle
            _theme5ThumbArtistTitle.value = response.theme5ThumbArtistTitle

            _artistProfileImage.value = response.artistProfileImage
            _artistNameRecommend.value = response.artistNameRecommend
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