package com.emreerkahraman.enerjisaassignment.ui.appointment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreerkahraman.enerjisaassignment.data.repository.AppointmentRepository
import com.emreerkahraman.enerjisaassignment.model.Menu
import com.emreerkahraman.enerjisaassignment.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppointmentViewModel @Inject constructor(private val  appointmentRepository: AppointmentRepository):ViewModel(){

    var appointmentViewState = MutableStateFlow(AppointmentViewState())


    init {
        getMenu()
    }
    fun getMenu(){
        viewModelScope.launch {
            appointmentRepository.getMenu().collect{
                onGetMenu(it)
            }
        }
    }

    private fun onGetMenu(resource: Resource<Menu?>) {
        appointmentViewState.value = AppointmentViewState(
            status = resource.status,
            error = resource.error?.message,
            menuList =resource.data?.result?.menuList
        )
    }


}