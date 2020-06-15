package com.shashank.assingment.responseModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PullRequestDatum(
    val state: String? = null,
    val title: String? = null,
    val user: UserDatum? = null,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updatedAt")
    val updatedAt: String? = null,
    @SerialName("closed_at")
    val closedAt: String
)