package com.example.myapplication_lab05.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication_lab05.R
import com.example.myapplication_lab05.ui.survey.SurveyViewModel
import com.example.myapplication_lab05.ui.home.HomeFragment

class ResultFragment : Fragment() {

    private lateinit var communicator: SurveyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_share, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        communicator = ViewModelProviders.of(activity!!).get(SurveyViewModel::class.java)
        val AnswerButton = view.findViewById<View>(R.id.SeeAnswer) as Button
        val NewButton = view.findViewById<View>(R.id.NewSurvey) as Button
        val textView = view.findViewById<View>(R.id.Number) as TextView

        //Shows times survey has been completed
        communicator.times.observe(this, object : Observer<Any> {
            override fun onChanged(t: Any?) {
                textView.text = t!!.toString()
            }
        })

        //Shows answers
        AnswerButton.setOnClickListener {
            communicator.getAnsCommunicator()
            Toast.makeText(context , communicator._text.toString(), Toast.LENGTH_SHORT).show()
        }
        //Starts a new survey
        NewButton.setOnClickListener {
            //Starts transitions among fragments
            val myFragment = HomeFragment()
            val fT = fragmentManager!!.beginTransaction()
            fT.replace(R.id.result_fragment, myFragment)
            fT.addToBackStack(null)
            fT.commit()
            NewButton.setVisibility(View.GONE)
            AnswerButton.setVisibility(View.GONE)

        }
    }
}