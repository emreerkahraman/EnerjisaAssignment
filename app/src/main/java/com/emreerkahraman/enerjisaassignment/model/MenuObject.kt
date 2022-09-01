package com.emreerkahraman.enerjisaassignment.model

import com.squareup.moshi.Json
data class MenuObject(
    @field:Json(name = "key")
    val key: Int?,
    @field:Json(name = "value")
    val value: String?
)