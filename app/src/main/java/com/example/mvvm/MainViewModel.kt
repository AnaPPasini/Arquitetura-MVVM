package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    //O MutableLiveDta é uma propriedade de data mutavel e viva ou seja que frequentemente é alterada
    private var textWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    private val personRepository = PersonRepository()


    //Usando o LiveData nao se pode mais alterar
    fun welcome(): LiveData<String>{
        return textWelcome
    }

    fun login(): LiveData<Boolean> {
        return login
    }

    fun doLogin (email: String, password: String) {
        login.value = personRepository.login(email,password)

    }

}