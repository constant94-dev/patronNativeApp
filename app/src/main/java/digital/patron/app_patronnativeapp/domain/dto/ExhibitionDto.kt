package digital.patron.app_patronnativeapp.domain.dto

import digital.patron.app_patronnativeapp.data.network.model.entity.Artist
import digital.patron.app_patronnativeapp.data.network.model.entity.Exhibition

data class ExhibitionDto(
    val id: List<Long>,
    val curationThumbName: List<String>,
    val curationArtistName: List<String>,
    val curationArtistCount: List<Integer>,
    val curationThumbnail: List<String>,
    val newlyArtworks: List<String>,
    val artistProfileImage: List<String>,
    val recommendArtistName: List<String>,
)
