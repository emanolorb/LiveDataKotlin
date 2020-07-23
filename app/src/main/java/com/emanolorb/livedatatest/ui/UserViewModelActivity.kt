package com.emanolorb.livedatatest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.emanolorb.livedatatest.R
import com.emanolorb.livedatatest.until.models.User
import com.emanolorb.livedatatest.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_user_view_model.*

class UserViewModelActivity : AppCompatActivity() {
    var userList: ArrayList<User> = ArrayList()
    lateinit var userViewModel:UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_view_model)
        setUpView()
    }
    fun setUpView(){
        // inicio el user view model
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        btSalvar.setOnClickListener {
            var user = User()
            user.edad = etEdad.text.toString()
            user.nombre = etNombre.text.toString()
            userList.add(user)
            userViewModel.addUser(user)
        }
        btVer.setOnClickListener {
            println("-------user list--------")
            println(userList)
            var texto = ""
            for (user in userList){
                texto += "${user.nombre} - ${user.edad}\n"
                tvUser.text = texto
            }
            var texto2 = ""
            for (user in userViewModel.userList){
                texto2 += "${user.nombre} - ${user.edad}\n"
                tvUserViewModel.text = texto2
            }
        }
    }
}
