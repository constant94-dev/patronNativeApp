package digital.patron.app_patronnativeapp.data.main.remote.dto

import com.google.gson.annotations.SerializedName

data class MainResponse(
    @SerializedName("code") val code: String,
)
