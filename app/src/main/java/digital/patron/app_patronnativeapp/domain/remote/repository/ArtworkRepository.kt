package digital.patron.app_patronnativeapp.domain.remote.repository

import digital.patron.app_patronnativeapp.domain.remote.model.Artwork
import digital.patron.app_patronnativeapp.di.RetrofitClient

class ArtworkRepository {

    suspend fun getArtwork(artworkId: Int): Artwork {
        return RetrofitClient.artwork_api.getArtwork(artworkId)
    }
}