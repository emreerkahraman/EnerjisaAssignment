package com.emreerkahraman.enerjisaassignment.ui.appointment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.emreerkahraman.enerjisaassignment.R
import com.emreerkahraman.enerjisaassignment.databinding.ItemAppointmentMenuBinding
import com.emreerkahraman.enerjisaassignment.model.MenuObject


class AppointmentMenuAdapter(var menuList: List<MenuObject>,var onClickMenu:(MenuObject) -> Unit ):
    RecyclerView.Adapter<AppointmentMenuAdapter.AppointmentMenuViewHolder>() {



    inner class AppointmentMenuViewHolder( private var binding:ItemAppointmentMenuBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(menuObject: MenuObject){
            binding.menuItem=menuObject
            binding.root.setOnClickListener {
               onClickMenu.invoke(menuObject)
            }

            when(menuObject.key){
                1 ->  binding.imageView2.setImageResource(R.drawable.ic_subscription)
                2 ->  binding.imageView2.setImageResource(R.drawable.ic_application)
                4 ->  binding.imageView2.setImageResource(R.drawable.ic_evacuation)
                5 ->  binding.imageView2.setImageResource(R.drawable.ic_transfer)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentMenuViewHolder {
        val binding: ItemAppointmentMenuBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_appointment_menu,parent, false
        )

        return AppointmentMenuViewHolder(binding)

    }

    override fun onBindViewHolder(holder: AppointmentMenuViewHolder, position: Int) {
      holder.bind(menuList[position])
    }

    override fun getItemCount(): Int =menuList.size
}
