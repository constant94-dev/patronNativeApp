package digital.patron.app_patronnativeapp.data.main.remote.dto

import com.google.gson.annotations.SerializedName

data class MainRequest(
    @SerializedName("code") val code: String,
)
