package digital.patron.app_patronnativeapp.data.network.model.entity

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

data class Exhibition(
    val id: Int,
    val code: String,
    val localization: String,
    val type: String,
    val docent: String,
    val start_date: LocalDate,
    val end_date: LocalDate,
    val create_time: LocalDateTime,
    val update_time: LocalDateTime,
    val number_of_likes: Int,
    val number_of_views: Int,
    val sale_member_id: Int,
    val business_member_id: Int,
    val number_of_shares: Int,
)
