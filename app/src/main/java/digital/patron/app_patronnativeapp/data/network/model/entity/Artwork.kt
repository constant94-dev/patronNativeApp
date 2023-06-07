package digital.patron.app_patronnativeapp.data.network.model.entity

import java.time.LocalDateTime
import java.util.Date

data class Artwork(
    val id: Int,
    val code: String,
    val localization: String,
    val size: String,
    val year: String,
    val belong: String,
    val nft_regist: Byte,
    val approve: Byte,
    val showing_update_time: LocalDateTime,
    val charge_free: Byte,
    val number_of_likes: Int,
    val number_of_views: Int,
    val views_excluding_this_month: Int,
    val create_time: LocalDateTime,
    val update_time: LocalDateTime,
    val duration_time: Int,
    val artist_id: Int,
    val sound_id: Int,
    val contents_4k_id: Int,
    val contents_thumbnail_id: Int,
    val sale_member_id: Int,
    val business_member_id: Int,
    val number_of_shares: Int,
    val shop_url: String,
)
