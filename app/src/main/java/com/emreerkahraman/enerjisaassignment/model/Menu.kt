package com.emreerkahraman.enerjisaassignment.model


import com.squareup.moshi.Json

data class Menu(
     @field:Json(name = "errorCode")
    val errorCode: String?,
     @field:Json(name = "errorMessage")
    val errorMessage: String?,
     @field:Json(name = "isMaintenance")
    val isMaintenance: Boolean?,
     @field:Json(name = "logUrl")
    val logUrl: String?,
     @field:Json(name = "requestId")
    val requestId: String?,
     @field:Json(name = "result")
    val result: Result?,
     @field:Json(name = "sid")
    val sid: String?,
     @field:Json(name = "statusCode")
    val statusCode: Int?,
     @field:Json(name = "validationErrorMessages")
    val validationErrorMessages: String?
) 