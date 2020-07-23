package com.emanolorb.livedatatest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.emanolorb.livedatatest.R
import com.emanolorb.livedatatest.until.sumar
import com.emanolorb.livedatatest.viewmodel.SumarViewModel
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {
    lateinit var sumarViewModel: SumarViewModel
    var resultado: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TAG1", "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        setUpView()
    }
    fun setUpView(){
        // instanciamos el viewmodel
        sumarViewModel = ViewModelProvider(this).get(SumarViewModel::class.java)
        tvSumarViewModel.text = sumarViewModel.resultado.toString()
        tvSumar.text = resultado.toString()
        btSumar.setOnClickListener {
            resultado = sumar.sumar(resultado)
            tvSumar.text = resultado.toString()
            sumarViewModel.resultado = sumar.sumar(sumarViewModel.resultado)
            tvSumarViewModel.text = sumarViewModel.resultado.toString()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("TAG1", "onStart()")
    }
    override fun onResume() {
        super.onResume()
        Log.d("TAG1", "onResume()")
    }
    override fun onPause() {
        super.onPause()
        Log.d("TAG1", "onPause()")
    }
    override fun onStop() {
        super.onStop()
        Log.d("TAG1", "onStop()")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG1", "onDestroy()")
    }
}
