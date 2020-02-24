package com.example.myapplication_lab05.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication_lab05.R
import com.example.myapplication_lab05.ui.share.ResultFragment

class SurveyFragment : Fragment() {

    lateinit var communicator: SurveyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        //No idea what is going in here
        val root = inflater.inflate(R.layout.fragment_survey, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Calling the modelView
        communicator = ViewModelProviders.of(activity!!).get(SurveyViewModel::class.java)
        communicator.createSurvey()
        var flag: Int = 0

        //UI
        val nextButton = view.findViewById<View>(R.id.nextButton) as Button
        val editText = view.findViewById<View>(R.id.answerEdit) as EditText
        val textView = view.findViewById<View>(R.id.text_gallery) as TextView

        //Getting the questions for the survey
        communicator.getMsgCommunicator(flag)
        communicator._text.observe(this, object : Observer<Any>{
            override fun onChanged(t: Any?) {
                textView.text = t!!.toString()
            }
        })

        //Button's action
        nextButton.setOnClickListener {
            communicator!!.setMsgCommunicator(editText.text.toString())
            if (flag < communicator.question.size-1) {
                flag += 1
                communicator.getMsgCommunicator(flag)
                communicator._text.observe(this, object : Observer<Any> {
                    override fun onChanged(t: Any?) {
                        textView.text = t!!.toString()
                    }
                })
            }
            //Next fragment
            else if (flag == communicator.question.size-1){
                //Starts transitions among fragments
                val myFragment = ResultFragment()
                val fT = fragmentManager!!.beginTransaction()
                fT.replace(R.id.gallery_fragment, myFragment)
                fT.addToBackStack(null)
                fT.commit()
                nextButton.setVisibility(View.GONE)
                communicator.setTimes()
            }

        }
    }
}