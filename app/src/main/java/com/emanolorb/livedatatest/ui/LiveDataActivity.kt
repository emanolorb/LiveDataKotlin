package com.emanolorb.livedatatest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.emanolorb.livedatatest.R
import com.emanolorb.livedatatest.until.models.User
import com.emanolorb.livedatatest.viewmodel.LiveDataViewModel
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {
    var numero: Int = 0
    lateinit var livedataViewModel: LiveDataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        setUpView()
    }
    fun setUpView(){
        livedataViewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)
        btSave.setOnClickListener {
            val user = User()
            when (numero) {
                0 -> {
                    user.edad = "18"
                    user.nombre = "Mat"
                }
                1 -> {
                    user.edad = "31"
                    user.nombre = "Emmanuel"
                }
                2 -> {
                    user.edad = "31"
                    user.nombre = "Melanie"
                }
                else -> {
                    user.edad = "unknown"
                    user.nombre = "unknown"
                }
            }
            numero += 1
            livedataViewModel.addUser(user)
        }
        // creamos un observable para cachar el cambio de la lista
        val listObserver = Observer<List<User>>{
            userList ->
            println("-------user list--------")
            println(userList)
            var texto = ""
            for (user in userList){
                texto += "${user.nombre} - ${user.edad}\n"
                tvLiveData.text = texto
            }
        }
        // asignamos el observer a la lista
        livedataViewModel.getUserList().observe(this, listObserver)
    }
}
