package com.emreerkahraman.enerjisaassignment.ui.appointment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.emreerkahraman.enerjisaassignment.R
import com.emreerkahraman.enerjisaassignment.base.BaseFragment
import com.emreerkahraman.enerjisaassignment.databinding.FragmentAppointmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class AppointmentFragment : BaseFragment<FragmentAppointmentBinding>() {
    private val appointmentViewModel: AppointmentViewModel by viewModels()


    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAppointmentBinding {
        return FragmentAppointmentBinding.inflate(inflater, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.onClickBack={
            activity?.onBackPressed()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            appointmentViewModel.appointmentViewState.collect { viewState ->

                if (viewState.isLoading()) {
                    return@collect
                }
                viewState.menuList?.let {

                    binding.menuRecyclerView.adapter = AppointmentMenuAdapter(viewState.menuList) {
                        findNavController().navigate(R.id.action_AppointmentFragment_to_NewSubscriptionFragment)
                    }
                    (binding.menuRecyclerView.adapter as AppointmentMenuAdapter).notifyDataSetChanged()
                }


            }

        }


    }




}