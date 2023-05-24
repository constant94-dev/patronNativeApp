package digital.patron.app_patronnativeapp.data.remote.dto

data class UserRequestDto(
    val id: String
)

data class UserResponseDto(
    val id: String,
    val name: String,
)