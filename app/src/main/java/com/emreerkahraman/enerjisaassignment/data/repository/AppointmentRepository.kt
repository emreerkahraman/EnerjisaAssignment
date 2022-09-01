package com.emreerkahraman.enerjisaassignment.data.repository

import android.util.Log
import com.emreerkahraman.enerjisaassignment.api.GithubService
import com.emreerkahraman.enerjisaassignment.base.BaseRepository
import javax.inject.Inject

class AppointmentRepository @Inject constructor(
    private val githubService: GithubService
) :BaseRepository(){

    suspend fun getMenu() = responseWrapper {
        Log.i("getmenu",githubService.getMenu().toString())
        githubService.getMenu()
    }


}