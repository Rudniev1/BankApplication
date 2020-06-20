package com.example.bankapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.util.*


class BlikActivity: Fragment(){


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.content_blik, container, false)
        }

        var code = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_back_from_blik).setOnClickListener {
            findNavController().navigate(R.id.action_blikActivity_to_homeActivity)
        }

        val random = Random()
        for(i in 0..5)
        {
           val randomNumber = random.nextInt(10)
            this.code += randomNumber.toString()
        }
        view.findViewById<TextView>(R.id.textView_blik_code).text = this.code
    }
}