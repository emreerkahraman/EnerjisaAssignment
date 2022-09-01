package com.emreerkahraman.enerjisaassignment.di.repository

import com.emreerkahraman.enerjisaassignment.api.GithubService
import com.emreerkahraman.enerjisaassignment.data.repository.AppointmentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object RepositoryModule {

    @Singleton
    @Provides
    fun provideAppointmentRepository(githubService: GithubService): AppointmentRepository {
        return AppointmentRepository(githubService)
    }
}