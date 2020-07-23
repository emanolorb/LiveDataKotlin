package com.emanolorb.livedatatest.viewmodel

import androidx.lifecycle.ViewModel
import com.emanolorb.livedatatest.until.models.User
import java.util.ArrayList

class UserViewModel : ViewModel{
    var userList: MutableList<User>
    constructor(){
        userList = ArrayList()
    }
    fun addUser(user: User){
        userList.add(user)
    }
}