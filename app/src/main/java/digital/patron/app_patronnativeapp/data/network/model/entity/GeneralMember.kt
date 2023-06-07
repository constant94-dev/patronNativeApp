package digital.patron.app_patronnativeapp.data.network.model.entity

import java.time.LocalDate
import java.time.LocalDateTime

data class GeneralMember(
    val id: Int,
    val email: String,
    val name: String,
    val status: String,
    val public_wallet: String,
    val birth: LocalDate,
    val nationality: String,
    val gender: String,
    val tutorial_check: Byte,
    val password: String,
    val last_login: LocalDateTime,
    val create_time: LocalDate,
    val mail_auth_key: String,
    val is_mail_certified: String,
    val provider: String,
    val marketing: Byte,
    val preferred_language: String,
)
