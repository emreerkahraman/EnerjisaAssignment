package com.emreerkahraman.enerjisaassignment.ui.appointment

import com.emreerkahraman.enerjisaassignment.model.MenuObject
import com.emreerkahraman.enerjisaassignment.model.Status

class AppointmentViewState(
    val status: Status = Status.LOADING,
    val error: String? = null,
    val menuList: List<MenuObject>? = null,
) {
    fun isLoading(): Boolean {
        return status == Status.LOADING
    }
}