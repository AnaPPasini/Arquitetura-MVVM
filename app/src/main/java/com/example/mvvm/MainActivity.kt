package com.example.mvvm

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Eventos
        binding.buttonLogin.setOnClickListener(this)

        // Variáveis
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Observadores
        setObserver()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_login) {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            viewModel.doLogin(email, password)
        }
    }


    //Aqui é o observado o `welcome`. O Observe this faz referencia em qual activity estamos e observador
    //é o text do arquivo xml que é `ligado` pelo binding

    private fun setObserver(){
    viewModel.welcome().observe(this, Observer { binding.textWelcome.text = it})

    viewModel.login().observe(this, Observer

        { if (it) {
            Toast.makeText(applicationContext, "Sucesso!", Toast.LENGTH_LONG). show()

        } else {
            Toast.makeText(applicationContext, "Falha", Toast.LENGTH_LONG).show()
        } })

    }


}