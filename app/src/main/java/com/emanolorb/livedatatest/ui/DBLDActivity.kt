package com.emanolorb.livedatatest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.emanolorb.livedatatest.R
import com.emanolorb.livedatatest.databinding.ActivityDbldBinding
import com.emanolorb.livedatatest.until.models.User
import com.emanolorb.livedatatest.viewmodel.LDDBViewModel

class DBLDActivity : AppCompatActivity() {
    lateinit var  viewModel: LDDBViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_dbld)
        val biding: ActivityDbldBinding = DataBindingUtil.setContentView(this,R.layout.activity_dbld)
        biding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(LDDBViewModel::class.java)
        biding.viewModel = viewModel
        viewModel.setManualUser(User("Radamesio","53"))
        viewModel.setVisible()
    }
}
