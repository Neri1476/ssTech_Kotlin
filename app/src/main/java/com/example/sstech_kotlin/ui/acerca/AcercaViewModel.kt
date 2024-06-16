package com.example.sstech_kotlin.ui.acerca

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AcercaViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Acerca de ..."
    }
    val text: LiveData<String> = _text
}