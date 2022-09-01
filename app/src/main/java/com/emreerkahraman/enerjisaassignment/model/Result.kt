package com.emreerkahraman.enerjisaassignment.model


import com.squareup.moshi.Json

data class Result(
    @field:Json(name = "errorCode")
    val errorCode: String?,
    @field:Json(name = "explanation")
    val explanation: String?,
    @field:Json(name = "isSuccess")
    val isSuccess: Boolean?,
    @field:Json(name = "jobID")
    val jobID: String?,
    @field:Json(name = "message")
    val message: String?,
    @field:Json(name = "params")
    val params: Params?,
    @field:Json(name = "requestContextID")
    val requestContextID: String?,
    @field:Json(name = "resultObject")
    val menuList: List<MenuObject>?
) 