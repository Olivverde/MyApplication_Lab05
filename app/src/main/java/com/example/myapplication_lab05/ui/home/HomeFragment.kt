package com.example.myapplication_lab05.ui.home

/**
 * @author Olivverde
 */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication_lab05.R
import com.example.myapplication_lab05.ui.survey.SurveyFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //Allows button visibility
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        StartButton.setOnClickListener{
            //Hides the button
            StartButton.setVisibility(View.GONE)

            //Starts transitions among fragments
            val myFragment = SurveyFragment()
            val fT = fragmentManager!!.beginTransaction()
            fT.replace(R.id.fragment_home, myFragment)
            fT.addToBackStack(null)
            fT.commit()
        }

    }

}