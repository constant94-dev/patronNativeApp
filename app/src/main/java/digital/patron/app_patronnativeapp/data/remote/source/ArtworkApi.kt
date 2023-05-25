package digital.patron.app_patronnativeapp.data.remote.source

import digital.patron.app_patronnativeapp.domain.remote.model.Artwork
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtworkApi {

    @GET("/artwork/{artworkId}")
    suspend fun getArtwork(@Path("artworkid") artworkId: Int): Artwork
}