package com.emreerkahraman.enerjisaassignment.ui.newsubscription


import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupWindow
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.emreerkahraman.enerjisaassignment.R
import com.emreerkahraman.enerjisaassignment.base.BaseFragment
import com.emreerkahraman.enerjisaassignment.databinding.FragmentNewSubscriptionBinding
import com.emreerkahraman.enerjisaassignment.extensions.toPx
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewSubscriptionFragment : BaseFragment<FragmentNewSubscriptionBinding>() {
    private val newSubscriptionViewModel: NewSubscriptionViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewSubscriptionBinding {
        return FragmentNewSubscriptionBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.onClickBack = {
            findNavController().navigateUp()
        }

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.select_dialog_item, mutableListOf("Type 1","Type 2")
        )
        binding.autoCompleteTextView.setAdapter(adapter)

        binding.autoCompleteTextView.setOnClickListener {
            binding.autoCompleteTextView.showDropDown()
        }

        binding.autoCompleteTextView.setOnItemClickListener { _, _, _, _ ->

            val subscriptionType=binding.autoCompleteTextView.text.toString()
            newSubscriptionViewModel.updateSubscriptionType(subscriptionType)

        }
        binding.ownerTypeRadioGroup.setOnCheckedChangeListener { _, checkedId ->

            when (checkedId) {
                binding.radio0.id -> {
                    newSubscriptionViewModel.updateOwnerType(OwnerType.OZEL)

                }
                binding.radio1.id -> {
                    newSubscriptionViewModel.updateOwnerType(OwnerType.TUZEL)
                }

            }
        }
        binding.nameEditText.addTextChangedListener {
            newSubscriptionViewModel.updateName(binding.nameEditText.text.toString())
        }
        binding.surnameEditText.addTextChangedListener {
            newSubscriptionViewModel.updateSurname(binding.surnameEditText.text.toString())
        }

        binding.surnameEditText.addTextChangedListener {
            newSubscriptionViewModel.updateId(binding.idEditText.text.toString())
        }

        binding.infoImageView.setOnClickListener {
            showPopupWindow()
        }

    }


    private fun showPopupWindow() {
        val popupView: View = LayoutInflater.from(context).inflate(R.layout.tooltip_security_deposit, null)

        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.MATCH_PARENT,
            300.toPx
        )
        popupView.findViewById<View>(R.id.closeButton).setOnClickListener {
            popupWindow.dismiss()
        }
        popupView.measure(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        popupWindow.showAsDropDown(binding.infoImageView,0,0)

        popupWindow.isOutsideTouchable = false
        popupWindow.isFocusable = true
        popupWindow.setBackgroundDrawable(BitmapDrawable())
    }


}