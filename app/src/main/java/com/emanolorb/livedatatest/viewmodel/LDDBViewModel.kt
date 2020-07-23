package com.emanolorb.livedatatest.viewmodel

import android.util.Size
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emanolorb.livedatatest.until.models.User

class LDDBViewModel: ViewModel() {
    var user : MutableLiveData<User> = MutableLiveData()
    var numero : Int = 0
    var visible : MutableLiveData<Boolean> = MutableLiveData()
    var colorize : MutableLiveData<Boolean> = MutableLiveData()
    var size: MutableLiveData<Float> = MutableLiveData(14f)

    fun setManualUser(user: User){
        this.user.value = user
    }
    fun setUser(){
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
        this.user.value = user
    }
    fun setVisible(){
        this.visible.value = true
        this.colorize.value = true
    }
    fun changeVisibility(){
        visible.value = visible.value != true
    }
    fun changeStyle(){
        colorize.value = colorize.value != true
        size.value = size.value!!.toFloat() + 1f
    }
}