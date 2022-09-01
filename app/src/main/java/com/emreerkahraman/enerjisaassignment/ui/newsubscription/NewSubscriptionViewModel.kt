package com.emreerkahraman.enerjisaassignment.ui.newsubscription

import androidx.lifecycle.ViewModel
import com.emreerkahraman.enerjisaassignment.ui.appointment.AppointmentViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class NewSubscriptionViewModel @Inject constructor():ViewModel() {
    var newSubscriptionViewState = MutableStateFlow(NewSubscriptionViewState())



    fun updateSubscriptionType(type:String) {
        newSubscriptionViewState.value=currentViewState().copy(subscriptionType =type)
    }
    fun updateOwnerType(type: OwnerType){
        newSubscriptionViewState.value=currentViewState().copy(ownerType =type)
    }

    fun updateName(name:String){
        newSubscriptionViewState.value=currentViewState().copy(name =name)
    }

    fun updateSurname(surname:String){
        newSubscriptionViewState.value=currentViewState().copy(surname =surname)
    }

    fun updateId(id:String){
        newSubscriptionViewState.value=currentViewState().copy(id =id)
    }

    private fun currentViewState(): NewSubscriptionViewState = newSubscriptionViewState.value

}