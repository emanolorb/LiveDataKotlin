package com.emanolorb.livedatatest.adapter

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.BindingAdapter
import com.emanolorb.livedatatest.R
import com.emanolorb.livedatatest.until.MyApp

object BidingAdapter {

    @JvmStatic
    @BindingAdapter("visible")
    fun setVisibility(view: View, visibility:Boolean){
        if (visibility == true)
        {
            view.visibility = View.VISIBLE
        }else{
            view.visibility = View.GONE
        }
    }
    @JvmStatic
    @BindingAdapter("colorido", "size")
    fun changeStyle(view: TextView, color:Boolean, size:Float ) {
        println("pintando----color")
        println(color)
        if (color)
        {
            view.setTextColor(getColor(MyApp.instance, R.color.colorAccent))
        }else{
            view.setTextColor(getColor(MyApp.instance, R.color.colorAccent2Dark))
        }
        view.textSize = size
    }
}