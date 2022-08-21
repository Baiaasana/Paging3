package com.example.apiwithpaging3.models

import com.squareup.moshi.Json

data class Data(
    val id: Int?,
    val email: String?,
    @field:Json(name = "first_name")
    val firstName: String?,
    @field:Json(name = "last_name")
    val lastName: String?,
    val avatar: String?,
)