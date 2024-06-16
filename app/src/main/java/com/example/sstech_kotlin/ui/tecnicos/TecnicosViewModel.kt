package com.example.sstech_kotlin.ui.tecnicos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TecnicosViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Técnicos"
    }
    val text: LiveData<String> = _text
}