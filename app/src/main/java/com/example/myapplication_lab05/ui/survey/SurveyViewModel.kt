package com.example.myapplication_lab05.ui.survey

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SurveyViewModel : ViewModel() {

    //Attributes
    val answer: MutableList<String> = ArrayList<String>()
    val question: MutableList<String> = ArrayList<String>()
    val _text = MutableLiveData<String>()
    var times = MutableLiveData<String>()
    var tim: Int = 0

    /**
     * Set the answers in the answer array
     */
    fun setMsgCommunicator(msg: String) {
        answer.add(msg)
    }

    /**
     * Extract the value from the question array
     */
    fun getMsgCommunicator(int: Int) {
        _text.setValue(question.get(int))
    }

    /**
     * Extract the value from the answer array
     */
    fun getAnsCommunicator(){
        var b: String = ""
        for ( x in 0 until answer.size){
            var a = answer.get(x)
            b += "Question "+(x+1)+": "+a+
            " "
        }
        _text.setValue(b)
    }

    /**
     * Express times that the survey has been completed
     */
    fun setTimes(){
       tim += 1
        times.setValue(tim.toString())
    }

    /**
     * Instances the initial survey
     */
    fun createSurvey() {
        question.clear()
        question.add("How do you rate our service? ")
        question.add("Any suggestion?")
    }
}