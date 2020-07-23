package com.emanolorb.livedatatest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.emanolorb.livedatatest.R
import com.emanolorb.livedatatest.databinding.ActivityDataBindingBinding
import com.emanolorb.livedatatest.until.models.User

class DataBindingActivity : AppCompatActivity() {
    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_data_binding)   lo comentamos para usar databinding
        // la clase ActivityDataBindingBinding la genera automaticamente kotlin
        val binding : ActivityDataBindingBinding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        user = User(
            "manolo",
            "32"
        )
        binding.user = user
        setUpView()
    }
    fun setUpView(){

    }
}
