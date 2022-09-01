package com.emreerkahraman.enerjisaassignment.api

import com.emreerkahraman.enerjisaassignment.model.Menu
import retrofit2.http.GET

interface GithubService {

    @GET("main/menu.json")
    suspend fun getMenu(): Menu?
}