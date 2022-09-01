package com.emreerkahraman.enerjisaassignment.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.emreerkahraman.enerjisaassignment.databinding.ToolbarBinding

class Toolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
     private var binding: ToolbarBinding

     lateinit var onClickBack:() ->(Unit)

    init {
        binding = ToolbarBinding.inflate(LayoutInflater.from(context), this, true)
        binding.backImageView.setOnClickListener {
            onClickBack.invoke()
        }
    }




   fun  setToolbarTitle(title: String){
       binding.toolbarTitle.text=title

   }

}


@BindingAdapter("toolbarTitle")
fun Toolbar.setTitle(
   title:String
) {
    this.setToolbarTitle(title)
}