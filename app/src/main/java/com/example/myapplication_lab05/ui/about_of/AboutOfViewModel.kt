package com.example.myapplication_lab05.ui.about_of

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutOfViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to MyApplication_lab05, surely the most boring name"+
                " in the world, actually i acknowledge this app as Abs Shaper 5000"+
                " obviously as a intent of attaching the greatest amount of users."+
                "I really hope you enjoy this low-budged app more than me"
    }
    val text: LiveData<String> = _text
}