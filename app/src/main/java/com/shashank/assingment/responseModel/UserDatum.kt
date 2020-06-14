package com.shashank.assingment.responseModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDatum (
    val login : String,
    @SerialName("avatar_url")
    val avatarUrl :String
)
