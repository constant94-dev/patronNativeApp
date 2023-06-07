package digital.patron.app_patronnativeapp.data.network.model

import digital.patron.app_patronnativeapp.data.network.model.entity.Artist
import digital.patron.app_patronnativeapp.data.network.model.entity.Artwork
import digital.patron.app_patronnativeapp.data.network.model.entity.Exhibition
import digital.patron.app_patronnativeapp.data.network.model.entity.GeneralMember
import kotlinx.serialization.Serializable
import java.util.Optional

/*
* Home 콘텐츠의 데이터 표현
* */
data class NetworkHome(
    val provider: String,
    val watchedArtworks: List<Artwork>,
    val likedArtworks: List<Artwork>,
    val alreadyWaiting: List<Boolean>,
    val leftTimeTillExhibition: List<Long>,
    val theme1: Optional<Exhibition>,
    val theme1DurationTime: String,
    val theme2: Optional<Exhibition>,
    val theme2DurationTime: String,
    val theme3: Optional<Exhibition>,
    val theme3DurationTime: String,
    val theme4: Optional<Exhibition>,
    val theme4DurationTime: String,
    val theme5: Optional<Exhibition>,
    val theme5DurationTime: String,
    val exhibitionDuration: List<String>,
    val mainExhibitions: List<Exhibition>,
    val exhibitions: List<Exhibition>,
    val exhibitionsDurationTime: List<String>,
    val newlyRegisteredArtworks: List<Artwork>,
    val generalMember: GeneralMember,
    val artists: List<Artist>,
    val deviceId: String,
    val language: String,
)
