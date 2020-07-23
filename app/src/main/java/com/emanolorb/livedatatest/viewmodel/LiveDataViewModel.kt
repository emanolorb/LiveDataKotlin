package com.emanolorb.livedatatest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emanolorb.livedatatest.until.models.User

class LiveDataViewModel: ViewModel() {
    // variable observable
    var userListLiveData: MutableLiveData<List<User>> = MutableLiveData()
    // variable no obsebable
    var userList: MutableList<User> = ArrayList()
    // MutableLiveData es de lectura y escritura
    // LiveData es solo de lectura


    fun getUserList(): LiveData<List<User>>{
        return userListLiveData
    }
    fun addUser(user: User){
        userList.add(user)
        userListLiveData.value = userList
        // value es en la activity activa
        // postvalue es para actualizar desde el hilo del backgraund
    }
}