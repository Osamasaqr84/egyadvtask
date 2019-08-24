package com.noname.task.model.entities

data class Login(
    val `data`: Data,
    val extra: List<Any>,
    val message: String,
    val status: Int
)

data class Data(
    val user: User
)

data class User(
    val city: City,
    val city_id: String,
    val confirm_code: Any,
    val created_at: String,
    val email_verified_at: Any,
    val extra_mobile: Any,
    val fmc_token: String,
    val following: String,
    val is_accepted: String,
    val is_active: String,
    val is_confirmed: String,
    val is_verified: String,
    val lang: String,
    val my_followers: String,
    val price_id: Any,
    val proff: Any,
    val recover: Any,
    val role: Any,
    val role_id: String,
    val sub_proff: Any,
    val updated_at: String,
    val upload_id: Any,
    val user_bio: Any,
    val user_credit: String,
    val user_email: String,
    val user_firstname: String,
    val user_header: Any,
    val user_id: Int,
    val user_img: String,
    val user_lastname: String,
    val user_lat: String,
    val user_lng: String,
    val user_mobile: String,
    val user_rate: String,
    val user_rate_count: String
)

data class City(
    val id: Int,
    val name: String
)
data class UserLogin(
    val username: String,
    val pass :String)