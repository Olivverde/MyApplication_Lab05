package com.example.myapplication_lab05.ui.about_of

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication_lab05.R

class AboutOfFragment : Fragment() {

    private lateinit var aboutOfViewModel: AboutOfViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutOfViewModel =
            ViewModelProviders.of(this).get(AboutOfViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_about_of, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        val image: ImageView = root.findViewById(R.id.ProfileImage)
        aboutOfViewModel.text.observe(this, Observer {
            textView.text = it
            image.setImageResource(R.drawable.ahegao)
        })
        return root
    }
}