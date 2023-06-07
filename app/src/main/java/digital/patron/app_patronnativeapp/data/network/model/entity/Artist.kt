package digital.patron.app_patronnativeapp.data.network.model.entity

import java.time.LocalDate

data class Artist(
    val id: Int,
    val code: String,
    val localization: String,
    val profile_img: String,
    val resume: String,
    val birth: LocalDate,
    val approve: Byte,
    val death_date: LocalDate,
    val death_check: Byte,
    val number_of_likes: Int,
    val create_time: LocalDate,
    val update_time: LocalDate,
    val number_of_shares: Int,
    val video: String,
)
