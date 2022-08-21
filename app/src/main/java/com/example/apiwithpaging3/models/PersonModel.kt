package com.example.apiwithpaging3.models

import com.squareup.moshi.Json

data class PersonModel(
    val page: Int?,
    @field:Json(name = "per_page")
    val perPage: Int?,
    val total: Int?,
    @field:Json(name = "total_pages")
    val totalPages: Int,
    val data: List<Data>,
    val support: Support?,
)